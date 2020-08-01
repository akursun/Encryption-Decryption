import java.util.Arrays;

class AsciiCharSequence implements java.lang.CharSequence {
    byte[] array;
    public AsciiCharSequence(byte[] arr) {
        this.array = arr;
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {

        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String total = "";
        for (int i = start; i < end ; i++) {
            total = total + ((char) array[i]);
        }
        return new AsciiCharSequence(Arrays.copyOfRange(array,start,end));
    }
    @Override
    public String toString() {
        return new String(this.array);
    }



}