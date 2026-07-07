//Name=Abdulahi Mohamed Ahmed
//        ID=C1240069
import java.util.Scanner;

public class jeep {

    // Variables caalami ah si looga isticmaalo methods-ka oo dhan
    static Scanner input = new Scanner(System.in);
    static double haraagaJeeb = 1000;
    static String pinSaxah = "1234";
    static boolean runProgram = true;

    public static void main(String[] args) {
        while (runProgram) {
            System.out.println("        -  JEEB -          ");
            System.out.println();
            System.out.println("garaac Code *810#: ");

            String ussdCode = input.next();

            if (!ussdCode.equals("*810#")) {
                System.out.println("\n[ERROR] Code-kan ma jiro. Fadlan garaac *810#.\n");
                continue;
            }

            // Method: Waxay maaraysaa gelinta iyo hubinta PIN-ka
            if (geliIyoHubiPin()) {
                // Method: Waxay furaysaa Menu-ga weyn haddii PIN-ku saxmo
                looxiiMenuweyn();
            }
        }
    }

    // -------------------------------------------------------------------------
    // METHOD 1: HUBINTA PIN-KA
    // -------------------------------------------------------------------------
    public static boolean geliIyoHubiPin() {
        int fursadaha = 3;
        while (fursadaha > 0) {
            System.out.print("\nFadlan geli PIN-kaaga sirta ah : ");
            String pinLaGaliyay = input.next();

            if (pinLaGaliyay.equals(pinSaxah)) {
                System.out.println("\n[SUCCESS] PIN-ka waa sax. Soo dhawaaw!");
                return true;
            } else {
                fursadaha--;
                System.out.println("[X] PIN-ka aad gelisay waa khaldan yahay!");
                if (fursadaha > 0) {
                    System.out.println("-> Waxaa kuu haray " + fursadaha + " fursadood.");
                } else {
                    System.out.println("[X] Waad gubtay fursadihii PIN-ka! Isku day mar kale.\n");
                }
            }
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // METHOD 2: MAIN MENU MAREYNTEEDA (Wuxuu isticmaalaa Array)
    // -------------------------------------------------------------------------
    public static void looxiiMenuweyn() {
        String[] menuItems = {
                "Itus Haraaga", "Kaarka hadalka", "Kaarka Internet", "Lacag Dirid",
                "Bixi Biil", "Warbixin Kooban", "Banks", "TAAJ", "Maareynta"
        };

        boolean menuJeep = true;
        while (menuJeep) {
            System.out.println("\n              JEEB               ");

            for (int i = 0; i < menuItems.length; i++) {
                System.out.println((i + 1) + ". " + menuItems[i]);
            }
            System.out.println("0. KaBax");
            System.out.print("Dooro nambarka adeega: ");

            String doorasho = input.next();

            switch (doorasho) {
                case "1":
                    adeegaItusHaraaga();
                    break;
                case "2":
                    adeegaKaarkaHadalka();
                    break;
                case "3":
                    adeegaKaarkaInternet();
                    break;
                case "4":
                    adeegaLacagDirid();
                    break;
                case "5":
                    adeegaBixiBiil();
                    break;
                case "6":
                    adeegaWarbixinKooban();
                    break;
                case "7":
                    adeegaBanks();
                    break;
                case "8":
                    adeegaTaaj();
                    break;
                case "9":
                    adeegaMaareynta(menuJeep);
                    // Maadaama Maareynta ay xiri karto barnaamijka oo dhan, waxaan hubinaa haddii runProgram la damiyay
                    if (!runProgram) {
                        menuJeep = false;
                    }
                    break;
                case "0":
                    System.out.println("\nWaad ku mahadsan tahay isticmaalka Somnet Jeeb.");
                    menuJeep = false;
                    runProgram = false;
                    break;
                default:
                    System.out.println(" Doorasho khaldan! Fadlan isku day markale.");
                    break;
            }
        }
    }

    // -------------------------------------------------------------------------
    // METHODS-KA ADEEGYADA GIDAHA (CASES-KII SWITH-KA OON WAXBA LA BEDELIN)
    // -------------------------------------------------------------------------
    public static void adeegaItusHaraaga() {
        System.out.println("\n          ITUS HARAAGA           ");
        System.out.println("Haraagaaga Jeeb waa: $" + haraagaJeeb);
        System.out.println("00. Noqo");
        System.out.print("Dooro: ");
        input.next();
    }

    public static void adeegaKaarkaHadalka() {
        System.out.println("\n          KAARKA HADALKA         ");
        System.out.println("1. Ku shubo Kaarka");
        System.out.println("2. U wareeji qof kale");
        System.out.println("00. Noqo");
        System.out.print("Dooro: ");
        String kaarkahadalka = input.next();

        if (kaarkahadalka.equals("1")) {
            System.out.print("Geli lacagta aad ku shubanayso ($): ");
            double kuShubo = input.nextDouble();
            if (kuShubo <= haraagaJeeb) {
                haraagaJeeb -= kuShubo;
                System.out.println("\n[SUCCESS] Waxaad ku shubatay $" + kuShubo + " oo kaarka hadalka ah.");
            } else {
                System.out.println("\n[ERROR] Haraagaaga ayaan ku filanayn!");
            }
        } else if (kaarkahadalka.equals("2")) {
            System.out.print("Geli lambarka loo wareejinayo kaarka: ");
            String lamberkaKaarka = input.next();
            System.out.print("Geli lacagta kaarka ($): ");
            double kuWareeji = input.nextDouble();
            if (kuWareeji <= haraagaJeeb) {
                haraagaJeeb -= kuWareeji;
                System.out.println("\n[SUCCESS] Waxaad $" + kuWareeji + " oo kaar ah u wareejisay " + lamberkaKaarka);
            } else {
                System.out.println("\n[ERROR] Haraagaaga ayaan ku filanayn!");
            }
        }
    }

    public static void adeegaKaarkaInternet() {
        System.out.println("\n         KAARKA INTERNET         ");
        System.out.println("1. Xirmo Maalinle ($0.50)");
        System.out.println("2. Xirmo Todobaadle ($2.00)");
        System.out.println("3. Xirmo Billaha ah ($10.00)");
        System.out.println("00. Noqo");
        System.out.print("Dooro: ");
        String internet = input.next();

        double qiimoXirmo = 0;
        String magacXirmo = "";

        if (internet.equals("1")) {
            qiimoXirmo = 0.50;
            magacXirmo = "Maalinle ah";
        } else if (internet.equals("2")) {
            qiimoXirmo = 2.00;
            magacXirmo = "Todobaadle ah";
        } else if (internet.equals("3")) {
            qiimoXirmo = 10.00;
            magacXirmo = "Billaha ah";
        }

        if (qiimoXirmo > 0) {
            if (qiimoXirmo <= haraagaJeeb) {
                haraagaJeeb -= qiimoXirmo;
                System.out.println("\n[SUCCESS] Waxaad ku shubatay Xirmo " + magacXirmo);
            } else {
                System.out.println("\n[ERROR] Haraagaaga  kuma filna!");
            }
        }
    }

    public static void adeegaLacagDirid() {
        System.out.println("\n           LACAG DIRID           ");
        System.out.print("Geli lambarka lacagta loo dirayo: ");
        String num = input.next();
        System.out.print("Geli lacagta ($): ");
        double lacag = input.nextDouble();

        if (lacag <= haraagaJeeb) {
            haraagaJeeb -= lacag;
            System.out.println("\n[SUCCESS]: $" + lacag + " waxaa loo diray " + num);
        } else {
            System.out.println("\n[ERROR] Haraagaaga  kuma filna!");
        }
        System.out.println("00. Noqo");
        System.out.print("Dooro: ");
        input.next();
    }

    public static void adeegaBixiBiil() {
        System.out.println("\n            BIXI BIIL            ");
        System.out.println("1. Biilka Korontada / Biyaha");
        System.out.println("2. Internet Biil (Somnet WiFi)");
        System.out.println("3. Ganacsi (Merchant ID)");
        System.out.println("00. Noqo");
        System.out.print("Dooro: ");
        String biil = input.next();

        if (biil.equals("1") || biil.equals("2")) {
            System.out.print("Geli Account Number-ka Biilka: ");
            String accNum = input.next();
            System.out.print("Geli lacagta Biilka ($): ");
            double biilLacag = input.nextDouble();
            if (biilLacag <= haraagaJeeb) {
                haraagaJeeb -= biilLacag;
                System.out.println("\n[SUCCESS] Biilka dhan $" + biilLacag + " waa la bixiyay.");
            } else {
                System.out.println("\n[ERROR] Haraagaaga  kuma filna!");
            }
        } else if (biil.equals("3")) {
            System.out.print("Geli Merchant ID-ga Ganacsiga: ");
            String merchant = input.next();
            System.out.print("Geli Lacagta ($): ");
            double mJanag = input.nextDouble();
            if (mJanag <= haraagaJeeb) {
                haraagaJeeb -= mJanag;
                System.out.println("\n[SUCCESS] $" + mJanag + " waxaa lagu bixiyay ganacsiga " + merchant);
            } else {
                System.out.println("\n[ERROR] Haraagaaga  kuma filna!");
            }
        }
    }

    public static void adeegaWarbixinKooban() {
        System.out.println("\n         Warbixin Kooban         ");
        System.out.println("1. Last Action: Lacag Dirid ($50)");
        System.out.println("2. Wareejintii u dambaysay: Dhismay kaar ($2)");
        System.out.println("3. Iibsashadii u dambeysay: Somnet Internet ($10)");
        System.out.println("00. Noqo");
        System.out.print("Dooro: ");
        input.next();
    }

    public static void adeegaBanks() {
        System.out.println("\n              Banks              ");
        System.out.println("1. Premier Bank");
        System.out.println("2. IBS Bank");
        System.out.println("3. Salaam Somali Bank");
        System.out.println("00. Noqo");
        System.out.print("Dooro bank-ga: ");
        String bank = input.next();
        if (bank.equals("1") || bank.equals("2") || bank.equals("3")) {
            System.out.println("1. Ka wareeji Bank oo u wareeji JEEB");
            System.out.println("2. Ka wareeji JEEB oo u wareeji Bank");
            System.out.print("Dooro: ");
            String bankAction = input.next();
            System.out.print("Geli lacagta ($): ");
            double bankLacag = input.nextDouble();
            if (bankAction.equals("2") && bankLacag <= haraagaJeeb) {
                haraagaJeeb -= bankLacag;
                System.out.println("\n[SUCCESS] $" + bankLacag + " waxaa loo wareejiyay Bank-ga.");
            } else if (bankAction.equals("1")) {
                haraagaJeeb += bankLacag;
                System.out.println("\n[SUCCESS] $" + bankLacag + " ayaa ka timid Bank-ga kuna soo dhacday Jeeb.");
            } else {
                System.out.println("\n[ERROR] Isku daygu wuu fashilmay.");
            }
        }
    }

    public static void adeegaTaaj() {
        System.out.println("\n              TAAJ               ");
        System.out.println("1. Gudaha (Xawaalad)");
        System.out.println("2. Dibadda");
        System.out.println("00. Noqo");
        System.out.print("Dooro: ");
        String taaj = input.next();
        if (taaj.equals("1") || taaj.equals("2")) {
            System.out.print("Geli Magaca Qaataha: ");
            input.nextLine();
            String magacaQaataha = input.nextLine();

            System.out.print("Geli Lacagta la dirayo ($): ");
            double taajLacag = input.nextDouble();
            if (taajLacag <= haraagaJeeb) {
                haraagaJeeb -= taajLacag;
                System.out.println("\n[SUCCESS] Lacagta TAAJ waxaa loo diray " + magacaQaataha + ", MTCN-kaaga waxaa loogu soo diri SMS.");
            } else {
                System.out.println("\n[ERROR] Haraagaagu kuguma filna.");
            }
        }
    }

    public static void adeegaMaareynta(boolean menuJeep) {
        boolean maareyntaMenu = true;
        while (maareyntaMenu) {
            System.out.println("\n            Maareynta            ");
            System.out.println("1. Bedel lambarka sirta ah");
            System.out.println("2. Bedel Luqadda");
            System.out.println("3. Wargelin Mobile Lumay");
            System.out.println("4. Lacag Xirasho");
            System.out.println("5. U celi lacag qaldantay");
            System.out.println("00. Noqo");
            System.out.println("0. KaBax");
            System.out.print("Dooro nambarka adeega: ");

            String maareynDooro = input.next();

            if (maareynDooro.equals("1")) {
                System.out.print("Geli PIN-kaaga Cusub: ");
                pinSaxah = input.next();
                System.out.println("\n[SUCCESS] PIN-kaaga si guul leh ayaa loo baddelay!");
                maareyntaMenu = false;
            } else if (maareynDooro.equals("2")) {
                System.out.println("\n[SUCCESS] Luqadda waxaa loo bedelay English/Somali.");
                maareyntaMenu = false;
            } else if (maareynDooro.equals("3")) {
                System.out.println("\n[SUCCESS] Wargelinta teleefanka lumay waa la diiwangeliyay.");
                maareyntaMenu = false;
            } else if (maareynDooro.equals("4")) {
                System.out.println("\n[SUCCESS] Koontadaada lacag xirashadeeda waa la codsaday.");
                maareyntaMenu = false;
            } else if (maareynDooro.equals("5")) {
                System.out.println("\n[SUCCESS] Codsiga soo celinta lacagta qaldantay waa la gudbiyay.");
                maareyntaMenu = false;
            } else if (maareynDooro.equals("00")) {
                maareyntaMenu = false;
            } else if (maareynDooro.equals("0")) {
                System.out.println("\nWaad ku mahadsan tahay isticmaalka Somnet Jeeb.");
                maareyntaMenu = false;
                runProgram = false;
            } else {
                System.out.println(" Doorasho khaldan! Fadlan isku day markale.");
            }
        }
    }
}
