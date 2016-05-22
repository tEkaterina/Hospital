package hospital.services;

import hospital.models.Doctor;
import hospital.models.Speciality;
import hospital.models.User;
import hospital.repositories.concrete.Repository;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

public class UserService {

    public static void addAdmin(User admin){
        Repository<User> adminRepository = new Repository<User>(User.class);
        adminRepository.add(admin);
        adminRepository.close();
    }

    public static void addDoctor(User user, Doctor doctor){
        Repository<User> userRepository = new Repository<User>(User.class);
        user.setRoleName(User.RoleName.Doctor);
        user.setDoctor(doctor);
        doctor.setUser(user);

        userRepository.save(doctor);
        userRepository.add(user);
        userRepository.close();
    }

    public static String MD5(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }

    public static byte[] saltGeneration(){
        SecureRandom random = new SecureRandom();
        byte bytes[] = random.generateSeed(20);
        return bytes;
    }

    public static boolean IsAuthorized(String strLog, String strPas){
        Repository<User> usersRepository = new Repository<User>(User.class);
        User currentUser = usersRepository.getByField("email", strLog);
        String salt = currentUser.getSalt();
        strPas = strPas + salt;
        return (currentUser.getPassword().equals(UserService.MD5(strPas)) && currentUser.getActivity());
    }

    public static User getCurrentUser(String strLog){
        Repository<User> usersRepository = new Repository<User>(User.class);

        User currentUser = usersRepository.getByField("email", strLog);

        return currentUser;
    }

    public static void IsFirstAdmin(){
        Repository<User> userRepository = new Repository<User>(User.class);
        String pass;
        User user = new User();
        user.setEmail("admin@gmail.com");
        pass = "admin";
        String salt = UserService.saltGeneration().toString();
        user.setSalt(salt);
        pass = pass + salt;
        user.setPassword(UserService.MD5(pass));
        user.setRoleName(User.RoleName.Admin);
        user.setActivity(true);
        userRepository.add(user);
    }

    public static boolean isValidAdmin(User admin, String password) {
        Repository<User> userRepository = new Repository<User>(User.class);
        if (admin == null || password == null ||
               password.equals("") || password.length() > 30)
            return false;

        User user = userRepository.getByField("email", admin.getEmail());
        if (user != null) return false;

        if (admin.getRoleName() == null) return false;
        return true;
    }

    public static boolean isValidDoctor(HttpServletRequest request) {
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String category = request.getParameter("category");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Repository<User> userRepository = new Repository<User>(User.class);
        User user = userRepository.getByField("email", email);
        if (name.equals("") || name.length() > 50){
            return false;
        }
        if (surname.equals("") || surname.length() > 50) {
            return false;
        }
        if (!UserService.contains(category)){
            return false;
        }
        if (phone.length() < 6 || phone.length() > 12) {
            return false;
        }
        if (user != null) {
            return false;
        }
        if (pass.length() < 3 || pass.length() > 30) {
            return false;
        }

        return true;
    }

    private static boolean contains(String test) {
        for (Doctor.Category c : Doctor.Category.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    public static String getTemplatePage(User user){
        if (user != null) {
            if (user.getRoleName().equals(User.RoleName.Admin)) {
                return "/Views/templatePages/adminTemplatePage.jsp";
            }
            else if(user.getRoleName().equals(User.RoleName.Doctor)){
                return "/Views/templatePages/doctorTemplatePage.jsp";
            }
        }
        return "";
    }
}
