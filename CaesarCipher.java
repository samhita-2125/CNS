import java.util.*;
class CaesarCipher
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int shift,i,n,p,key;
String str;
String str1="";
System.out.println("Enter the Plain Text");
str=sc.nextLine();
str=str.toLowerCase();
n=str.length();
char ch1[]=str.toCharArray();
char ch4;
System.out.println("Enter the value by which each letter of the string is to be shifted");
shift=sc.nextInt();
System.out.println();
System.out.println("Encrypted text is:");
for(i=0;i<n;i++)
{
if(Character.isLetter(ch1[i]))
{
ch4=(char)(((int)ch1[i]+shift-97)%26+97);
str1=str1+ch4;
}
else if(ch1[i]==' ')
{
str1=str1+ch1[i];
} 
}
System.out.println(str1);
System.out.println("Cipher Text:"+str1);
n=str1.length();
char ch2[]=str1.toCharArray();
char ch3;
System.out.println();
System.out.println("Possible Plain text is");
str1="";
for(key=26;key>=1;key--)
{
for(i=0;i<n;i++)
{
if(Character.isLetter(ch2[i]))
{
ch3=(char)(((int)ch2[i]+key-97)%26+97);
str1=str1+ch3;
} 
else if(ch2[i]==' ')
{
str1=str1+ch2[i];
} 
}
p=26-key;
System.out.println("For Key "+p+":"+str1);
str1="";
}
}
}