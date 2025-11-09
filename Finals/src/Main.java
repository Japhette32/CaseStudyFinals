import javax.swing.*;

    public class Main {

        private static final String[][] accounts = {
                {"0123-4567-8901", "Roel Richard", "5000.00", "1111", "Active"},
                {"2345-6789-0123", "Dorie Marie", "0.00", "2222", "Blocked"},
                {"3456-7890-1234", "Railee Darrel", "10000.00", "3333", "Active"},
                {"4567-8901-2345", "Railynne Dessirei", "2500.00", "4444", "Active"},
                {"5678-9012-3456", "Raine Dessirei", "10000.00", "5555", "Active"}
                {"5678-9012-3456", "AHJFHASJDFH", "10000.00", "5555", "Active"}
        };

        public static String Output1() {
            return JOptionPane.showInputDialog(null,
                    "S --> Start Transaction\n"
                            + "Q --> Quit\n"
                            + "Enter your choice:",
                    "Brian Pogi Banking Corporation", JOptionPane.PLAIN_MESSAGE);
        }

        public static boolean Output2() {
            int attempts = 3;
            int accindex = -1;

            while (true) {
                String accountNumber = JOptionPane.showInputDialog(null,
                        "Enter your account number:", "Brian Pogi Banking Corporation", JOptionPane.PLAIN_MESSAGE);
                accountNumber = accountNumber.trim();

                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i] != null && accountNumber.equals(accounts[i][0])) {
                        accindex = i;
                        break;
                    }
                }

                if (accindex >= 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "You've entered the wrong Account Number", "Brian Pogi Banking Corporation", JOptionPane.WARNING_MESSAGE);
                }
            }

            if ("Blocked".equalsIgnoreCase(accounts[accindex][4])) {
                JOptionPane.showMessageDialog(null, "CAPTURED CARD\nPlease Call: 0967-420-69", "Brian Pogi Banking Corporation", JOptionPane.WARNING_MESSAGE);
                return false;
            }

            while (attempts > 0) {
                String pinNumber = JOptionPane.showInputDialog(null, "Enter your pin number:", "Brian Pogi Banking Corporation", JOptionPane.PLAIN_MESSAGE);
                if (pinNumber == null) {
                    return false;
                }
                pinNumber = pinNumber.trim();

                if (pinNumber.equals(accounts[accindex][3])) {
                    return true;
                } else {
                    attempts--;
                    if (attempts == 0) {
                        accounts[accindex][4] = "Blocked";
                        JOptionPane.showMessageDialog(null, "CAPTURED CARD\nPlease Call: 0967 - 420 - 6967", "Brian Pogi Banking Corporation", JOptionPane.WARNING_MESSAGE);
                        return false;
                    } else {
                        JOptionPane.showMessageDialog(null, "You've entered the wrong pin\nAttempts left: " + attempts, "Brian Pogi Banking Corporation", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            return false;
        }

        public static char TypeOfTransaction() {
            while (true) {
                String output = JOptionPane.showInputDialog(null,
                        "B --> Balance Inquiry \n"
                                + "W --> Withdrawal \n"
                                + "D --> Deposit \n"
                                + "T --> Transfer Fund \n"
                                + "C --> Cancel \n"
                                + "Enter your choice:", "Brian Pogi Banking Corporation", JOptionPane.PLAIN_MESSAGE);
                if (output == null) {
                    continue;
                }
                output = output.trim();
                if (output.length() == 0) {
                    continue;
                }

                String choice = output.trim().toLowerCase();
                char choicechar = choice.charAt(0);
                return choicechar;
            }
        }

        public static void main(String[] args) {

            while (true) {
                String choice;
                choice = Output1();
                if (choice == null) {
                    continue;
                }
                if (choice.length() == 0)
                    continue;

                choice = choice.trim();

                char choicechar = choice.trim().charAt(0);
                if (choicechar == 's' || choicechar == 'S') {
                    boolean authenticated = Output2();
                    if (authenticated == true) {
                        char choiceTypeOfTransaction = TypeOfTransaction();
                        if (choiceTypeOfTransaction == 'c' || choiceTypeOfTransaction == 'C') {
                            continue;
                        }
                    }
                } else if (choicechar == 'q' || choicechar == 'Q') {
                    JOptionPane.showMessageDialog(null, "Thank you for using Brian Gwapo Banking Corporation!", "BGBC", JOptionPane.PLAIN_MESSAGE);
                    break;
                }
            }
        }
    }

