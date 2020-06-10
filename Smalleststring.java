class Result {


static void sort(String a[], int n)
{
for(int i = 0;i < n;i++)
{
for(int j = i + 1;j < n;j++)
{
if((a[i] + a[j]).compareTo(a[j] + a[i]) > 0)
{
String s = a[i];
a[i] = a[j];
a[j] = s;
}
}
}
}


public static String smallestString(List<String> substrings) {

String str[] = new String[substrings.size()];
for (int j = 0; j < substrings.size(); j++) {
str[j] = substrings.get(j);
}
int n=str.length;
sort(str,n);
String answer = "";
for (int i = 0; i < n; i++)
answer += str[i];
return answer;

}

}
