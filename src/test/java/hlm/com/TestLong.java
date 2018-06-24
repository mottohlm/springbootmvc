package hlm.com;


public class TestLong {

	public static void main(String[] args) {
		String lstr = "12";
		Long l1 = Long.getLong("");
		Long l2 = Long.valueOf(lstr);
		System.out.println(l1);
		System.out.println(l2);
		
		
		
		
		
		
		
		
		
	//	Long l1 = getLong(lstr);
		
		Long l3 = Long.parseLong(lstr);
		Long l4= parseLong(lstr,10);
		//Long l2 = valueOf(lstr);
		
		System.out.println(l3);
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version"));

	}
	public static Long getLong(String paramString){
		// paramString = System.getProperty(paramString);

	    int i = 10;
	    int j = 0;
	    int k = 0;
	    if (paramString.length() == 0) {
	      throw new NumberFormatException("Zero length string");
	    }
	    int m = paramString.charAt(0);
	    if (m == 45)
	    {
	      k = 1;
	      j++;
	    }
	    else if (m == 43)
	    {
	      j++;
	    }
	    if ((paramString.startsWith("0x", j)) || (paramString.startsWith("0X", j)))
	    {
	      j += 2;
	      i = 16;
	    }
	    else if (paramString.startsWith("#", j))
	    {
	      j++;
	      i = 16;
	    }
	    else if ((paramString.startsWith("0", j)) && (paramString.length() > 1 + j))
	    {
	      j++;
	      i = 8;
	    }
	    if ((paramString.startsWith("-", j)) || (paramString.startsWith("+", j))) {
	      throw new NumberFormatException("Sign character in wrong position");
	    }
	    Long localLong;
	    try
	    {
	      localLong = valueOf(paramString.substring(j), i);
	      localLong = k != 0 ? valueOf(-localLong.longValue()) : localLong;
	    }
	    catch (NumberFormatException localNumberFormatException)
	    {
	      String str = k != 0 ? "-" + paramString.substring(j) : paramString.substring(j);
	      localLong = valueOf(str, i);
	    }
	    return localLong;
	  
	}
	
	public static Long valueOf(String paramString, int paramInt)
		    throws NumberFormatException
		  {
		    return valueOf(parseLong(paramString, paramInt));
		  }
		  
		  public static Long valueOf(String paramString)
		    throws NumberFormatException
		  {
		    return valueOf(parseLong(paramString, 10));
		  }
		  
		  public static Long valueOf(long paramLong)
		  {
		    if ((paramLong >= -128L) && (paramLong <= 127L)) {
		      return LongCache.cache[((int)paramLong + 128)];
		    }
		    return new Long(paramLong);
		  }
		  public static long parseLong(String paramString, int paramInt)
				    throws NumberFormatException
				  {
				    if (paramString == null) {
				      throw new NumberFormatException("null");
				    }
				    if (paramInt < 2) {
				      throw new NumberFormatException("radix " + paramInt + " less than Character.MIN_RADIX");
				    }
				    if (paramInt > 36) {
				      throw new NumberFormatException("radix " + paramInt + " greater than Character.MAX_RADIX");
				    }
				    long l1 = 0L;
				    int i = 0;
				    int j = 0;
				    int k = paramString.length();
				    long l2 = -9223372036854775807L;
				    if (k > 0)
				    {
				      int n = paramString.charAt(0);
				      if (n < 48)
				      {
				        if (n == 45)
				        {
				          i = 1;
				          l2 = Long.MIN_VALUE;
				        }
				        else if (n != 43)
				        {
				         // throw NumberFormatException.forInputString(paramString);
				        }
				        if (k == 1) {
				        //  throw NumberFormatException.forInputString(paramString);
				        }
				        j++;
				      }
				      long l3 = l2 / paramInt;
				      while (j < k)
				      {
				        int m = Character.digit(paramString.charAt(j++), paramInt);
				        if (m < 0) {
				          //throw NumberFormatException.forInputString(paramString);
				        }
				        if (l1 < l3) {
				         // throw NumberFormatException.forInputString(paramString);
				        }
				        l1 *= paramInt;
				        if (l1 < l2 + m) {
				         // throw NumberFormatException.forInputString(paramString);
				        }
				        l1 -= m;
				      }
				    }
				    else
				    {
				      //throw NumberFormatException.forInputString(paramString);
				    }
				    return i != 0 ? l1 : -l1;
				  }
	 
	 private static class LongCache
	  {
	    static final Long[] cache = new Long['?'];
	    
	    private LongCache() {}
	    
	    static
	    {
	      for (int i = 0; i < cache.length; i++) {
	        cache[i] = new Long(i - 128);
	      }
	    }
	  }
}
