
class Result {

public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {

int error = 0, i, j;
for(i=0; i<productSold.size(); i++)
{
String str = productSold.get(i);
for(j=0; j<products.size(); j++)
{
String st = products.get(j);
if(st.equals(str))
break;
}
if(!(soldPrice.get(i).equals(productPrices.get(j))))
error++;
}
return error;
}
}
