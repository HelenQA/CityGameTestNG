package by.htp.cityname.entity;

public final class City {

	private String _strName;
	private char _chrFirstChar;
	private char _chrLastChar;
	private char[] chrExceptionsChar = {'.', 'Й','Ы','Ь', 'Ъ'};
	
	public City(String strName) {
		this._strName = strName.toUpperCase();
		char[] chrArray = this._strName.toCharArray();
		this._chrFirstChar = chrArray[0];
		this._chrLastChar = defineCorrectLastChar(chrArray);
	}
	
	private char defineCorrectLastChar(char[] chrArray){
		char chrLastSymb = chrArray[chrArray.length-1];
		char check = chrLastSymb;
		for (int i = chrArray.length-1; i > 0; i-- ) {
			for (char symb: chrExceptionsChar){
				if (chrArray[i]==symb) {
					chrLastSymb = chrArray[i-1];
				}
			}
			if (check == chrLastSymb){break;
			} else {check = chrLastSymb;
			} 
		}
		return chrLastSymb;
	}

	public String getName() {
		return _strName;
	}

	public char getFirstChar() {
		return _chrFirstChar;
	}


	public char getLastChar() {
		return _chrLastChar;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _chrFirstChar;
		result = prime * result + _chrLastChar;
		result = prime * result + ((_strName == null) ? 0 : _strName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (_chrFirstChar != other._chrFirstChar)
			return false;
		if (_chrLastChar != other._chrLastChar)
			return false;
		if (_strName == null) {
			if (other._strName != null)
				return false;
		} else if (!_strName.equals(other._strName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [Name=" + _strName + ", First Char=" + _chrFirstChar + ", Last Char=" + _chrLastChar
				+ "]";
	}
}
