public class StringManipulator(){

    //1ra manera
    public String trimAndConcat(String primert, String segundot){
        String primertrim = primert.trim();
        String segundotrim = segundot.trim();
        return primertrim.concat(segundotrim);
    }

    //2da manera
    public int getIndexOrNull(String str, char letter) {
        return str.indexOf(letter);
    }

    //3ra manera
    public int getIndexOrNull(String word, String subString){
        word.indexOf(subString);
        return word.indexOf(subString);
    }

    //4ta manera
    public String concatSubstring(String hola, int indexinicial, int indexfianl, String mundo){
        return hola.substring(indexinicial, indexfianl) + mundo;
    }
}