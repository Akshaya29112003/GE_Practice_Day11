public class User_Registration_junit {

    public static boolean first_name(String fname) {
        String fname_regex = "^[A-Z][A-Za-z]{2,}$";
        if (fname.matches(fname_regex)) {
            System.out.println("First Name Valid");
            return true;
        } else {
            System.out.println("First Name Not Valid. It must start with a capital letter and have at least 3 characters.");
            return false;
        }
    }

    public static boolean last_name(String lname) {
        String lname_regex = "^[A-Z][A-Za-z]{2,}$";
        if (lname.matches(lname_regex)) {
            System.out.println("Last Name Valid");
            return true;
        } else {
            System.out.println("Last Name Not Valid. It must start with a capital letter and have at least 3 characters.");
            return false;
        }
    }

    public static boolean Email(String email) {
        String email_regex = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
        if (email.matches(email_regex)) {
            System.out.println("Email Valid");
            return true;
        } else {
            System.out.println("Email Not Valid. It must follow the format abc.xyz@bl.co.in.");
            return false;
        }
    }

    public static boolean Phone(String phn) {
        String phn_regex = "^[0-9]{2} [0-9]{10}$";
        if (phn.matches(phn_regex)) {
            System.out.println("Phone Number Valid");
            return true;
        } else {
            System.out.println("Phone Number Not Valid. It must follow the format 91 9919819801.");
            return false;
        }
    }

    public static boolean Password(String pass) {
        // Updated regex for a password with minimum 8 characters, at least one uppercase, one lowercase, one number, and exactly one special character
        String pass_regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        int specialCharCount = pass.replaceAll("[^@#$%^&+=!]", "").length();

        if (pass.matches(pass_regex) && specialCharCount == 1) {
            System.out.println("Password Valid");
            return true;
        } else {
            System.out.println("Password Not Valid. It must have:\n"
                    + "- Minimum 8 characters\n"
                    + "- At least 1 uppercase letter\n"
                    + "- At least 1 numeric digit\n"
                    + "- Exactly 1 special character.");
            return false;
        }
    }
}
