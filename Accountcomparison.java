
class Account implements OnlineAccount, Comparable<Account> {

int noOfRegularMovies, noOfExclusiveMovies;
String ownerName;
Account (String oname,int nrm, int nem)
{
this.ownerName = oname;
this.noOfRegularMovies=nrm;
this.noOfExclusiveMovies=nem;
}
@Override
public int compareTo(Account o) {
// TODO Auto-generated method stub
if (this.monthlyCost()>o.monthlyCost())
{
this.toString();
return 1;
}
else
{
o.toString ();
return -1;
}

}

public String toString() {
String s = new String ();
s="Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
return s;

}
}
