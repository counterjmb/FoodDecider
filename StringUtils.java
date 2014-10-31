/*StringUtils.java provided by William Bowers III
 *Used by James Beagle for final project
 *November 2010, 1531SN
 */

public class StringUtils
{
	public static String padWithSpaces(String s, int length)
	{
		if (s.length() < length)
		{
			StringBuilder sb = new StringBuilder(s);
			while(sb.length() < length)
			{
				sb.append(" ");
			}
			return sb.toString();
		}
		else
		{
			return s.substring(0, length);
		}
	}
}