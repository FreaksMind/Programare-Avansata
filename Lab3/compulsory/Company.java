package lab3.compulsory;

public class Company implements Comparable<Company>, Node {

	//Al shrafat Maroan
	
	private String name;

	public Company() {
		this.name = "";
	}

	public Company(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Company o) {
		if (o == null)
			return 0;

		return this.name.compareTo(o.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.name);

		return sb.toString();

	}

}
