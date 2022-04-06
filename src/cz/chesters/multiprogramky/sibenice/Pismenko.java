package cz.chesters.multiprogramky.sibenice;

public class Pismenko {
    String znak;
    boolean visible = false;

    public Pismenko(String z){
        this.znak = z;
        this.visible = false;
    }

    public boolean equals(String s) {
        if (s == null) return false;
        return znak.equals(s);
    }

    @Override
    public String toString() {
        return znak;
    }
}
