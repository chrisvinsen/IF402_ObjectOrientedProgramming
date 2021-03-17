package week12.christianto.ac.id.umn;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.AuthenticationException;
import exceptions.ExcessiveFailedLoginException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static ArrayList<User> users = new ArrayList<User>();
	static Scanner s = new Scanner(System.in);

	private static Pattern pattern;
	private static Matcher matcher;
	private static final String PASSWORD_REGEX =
			"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,16}$";
	private static final Pattern PASSWORD_PATTERN =
			Pattern.compile(PASSWORD_REGEX);


	public static void initialize() {

		MessageDigest digest;

		try{
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest();

			users.add(new User("John", "Doe", 'L', "Jl. Merpati No. 1 RT 1 RW 2, Banten", "admin", "admin", digest));

		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public static void handleLogin() throws AuthenticationException, ExcessiveFailedLoginException{

		String uname;
		String pass;

		while(true) {
			int status = 0;

			System.out.print("Username : ");
			uname = s.nextLine();
			System.out.print("Password : ");
			pass = s.nextLine();
			for(int i = 0; i < users.size(); i++) {
				try {
					if(users.get(i).login(uname, pass)) {
						status = 0;;
						System.out.println(users.get(i).greeting() + "\n");
					}else {
						status++;
					}
				}catch(ExcessiveFailedLoginException ex) {
					System.out.println(ex.getMessage());
				}
			}
			if(status  == users.size()) {
				AuthenticationException auth = new AuthenticationException();
				System.out.println(auth.getMessage());
			}
		}
	}

	public static void handleSignUp() {

		String nama_depan, nama_belakang, alamat, username, password;
		Character jenis_kelamin;

		while(true) {
			System.out.print("Nama Depan          : ");
			nama_depan = s.nextLine();
			System.out.print("Nama Belakang       : ");
			nama_belakang = s.nextLine();
			System.out.print("Jenis Kelamin (L/P) : ");
			jenis_kelamin = s.nextLine().charAt(0);
			if(jenis_kelamin != 'L' && jenis_kelamin != 'P') {
				System.out.println("Jenis kelamin tidak valid.\n");
				continue;
			}
			System.out.print("Alamat              : ");
			alamat = s.nextLine();
			System.out.print("Username            : ");
			username = s.nextLine();
			if(username.length() <= 8) {
				System.out.println("Username harus lebih dari 8 karakter.\n");
				continue;
			}
			System.out.print("Password            : ");
			password = s.nextLine();
			if (!PASSWORD_PATTERN.matcher(password).matches()) {
				System.out.println("Password harus mengandung huruf besar, angka, minimum 6 karakter dan maksimum 16 karakter\n");
				continue;
			}
			break;
		}
		System.out.println("User telah berhasil didaftarkan\n");

		MessageDigest digest;

		try{
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest();

			users.add(new User(nama_depan , nama_belakang, jenis_kelamin, alamat, username, password, digest));

		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) throws AuthenticationException, ExcessiveFailedLoginException {

		int pilihan = 0;

		initialize();

		while(true) {
			System.out.println("1. Login");
			System.out.println("2. Sign Up");
			System.out.print("Pilihan : ");
			pilihan = s.nextInt();
			s.nextLine();
			if(pilihan == 1) {
				handleLogin();
			}else if(pilihan == 2) {
				handleSignUp();
			}else {
				System.out.println("Invalid Input\n");
			}
		}

	}

}
