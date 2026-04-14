package hashEqual;

public class RunCode {
	public static void main(String[] args) {
		// ----------------------------------------Student-----------------------------------------------
		Student s1 = new Student(new Name("Sepp", "Forcher"), new Adress("Landgasse", 19,8791, "Jodelberg"));
		Student s2 = new Student(new Name("Sepp", "Forcher"), new Adress("Landgasse", 19,8791, "Jodelberg"));
		Student s3 = new Student(new Name("Sepp", "Forcher"), new Adress("Landgasse", 19,8791, "Jodelberg"));
		Student s4 = new Student(new Name("Ilse", "Bäcker"), new Adress("BErgasse", 19,6767, "Jodelberg"));
		
		System.out.println(s1);
		System.out.println(s4);
		
		//-----------------------------------------------------Reflexitivität----------------------------
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Reflexivität: \t\t " + s1.equals(s1));
		
		//-----------------------------------------------------Symmetrie----------------------------
		if(s1.equals( s2) == s2.equals(s1)) { //Wenn vergleich in Beide Richtungrn
			System.out.println("Symmetrie: \t\t " + true );
		}else {
			System.out.println("Symmetrie: \t\t " + false );
		}
		//------------------------------------------------------Transitivität------------------------------------------
		if(s1.equals( s2) && s2.equals(s3)) {
		System.out.println("Symmetrie: \t\t " + true );
		}else {
			System.out.println("Symmetrie: \t\t " + false );
		}
		//--------------------------------------------------Kositenz-------------------------------------------------
		boolean first = s1.equals(s2);
		boolean second = s1.equals(s2);
		System.out.println("Konsitent \t\t " + (first == second));
		
		//---------------------------------------------------Unterschied zu Null-----------------------------------
	if(s1.equals(null)) {
		System.out.println("Unterschied zu null: \t "+false);
	}else {
		System.out.println("Unterschied zu null: \t "+true);
	}
	//--------------------------------------------
	//Adresss-----------------------------------------------------
	//--------------------------------------------
	
	Adress a1 = new Adress("Baumgasse", 12, 8700, "Leoben");
	Adress a2 = new Adress("Baumgasse", 12, 8700, "Leoben");
	Adress a3 = new Adress("Baumgasse", 12, 8700, "Leoben");

	//-----------------------------------------------------Reflexitivität----------------------------
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Reflexivität: \t\t " + s1.equals(s1));
			
			//-----------------------------------------------------Symmetrie----------------------------
			if(a1.equals( a1) == a2.equals(a1)) { //Wenn vergleich in Beide Richtungrn
				System.out.println("Symmetrie: \t\t " + true );
			}else {
				System.out.println("Symmetrie: \t\t " + false );
			}
			//------------------------------------------------------Transitivität------------------------------------------
			if(a1.equals( a2) && a2.equals(a3)) {
			System.out.println("Symmetrie: \t\t " + true );
			}else {
				System.out.println("Symmetrie: \t\t " + false );
			}
			//--------------------------------------------------Kositenz-------------------------------------------------
			boolean one = a1.equals(a2);
			boolean two = a1.equals(a2);
			System.out.println("Konsitent \t\t " + (one == two));
			
			//---------------------------------------------------Unterschied zu Null-----------------------------------
		if(a1.equals(null)) {
			System.out.println("Unterschied zu null: \t "+false);
		}else {
			System.out.println("Unterschied zu null: \t "+true);
		}
	}
	
}
