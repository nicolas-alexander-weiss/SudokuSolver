public class Cell {

    public static byte MIN_VALUE = 1;
    public static byte MAX_VALUE = 9;

    private byte value;
    private boolean fixed;

    public Cell(byte value) { //, boolean fixed){
        setValue(value);
        setFixed(false);
    }

    /*

     public Cell(byte signedValue){
        if(signedValue < 0){
         setValue(Math.abs(signedValue));
         setFixed(true);
        }else{
         setValue(value);
         setFixed(false);
        }

     }
    */
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean setValue(byte value) {
        if (value <= 0) {
            this.value = MIN_VALUE;
            return false;
        } else if (value > 9) {
            this.value = MAX_VALUE;
            return false;
        } else {
            this.value = value;
            return true;
        }
    }

    public byte getValue() {
        return value;
    }


    public void swap(Cell c) {
        byte temp = c.getValue();

        c.setValue(value);

        this.setValue(temp);
    }

}
