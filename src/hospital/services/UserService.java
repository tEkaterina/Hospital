package hospital.services;

import hospital.models.User;
import hospital.repositories.concrete.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Balashechka on 20.05.2016.
 */
public class UserService {

    public static void addAdmin(User admin){
        Repository<User> adminRepository = new Repository<User>(User.class);
        adminRepository.add(admin);
        adminRepository.close();
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
        if (currentUser.getPassword().equals(UserService.MD5(strPas)) && currentUser.getActivity()){
            return true;
        }
        else{
            return false;
        }
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
}
