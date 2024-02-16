package AircraftCarrier;

public class Aircraft {
    protected int currentAmmo;
    protected int maxAmmo;
    protected int baseDamage;

    public Aircraft(int maxAmmo, int baseDamage) {
        this.maxAmmo = maxAmmo;
        this.baseDamage = baseDamage;
        this.currentAmmo = 0;
    }

    public int fight() {
        int damageDealt = baseDamage * currentAmmo;
        currentAmmo = 0;
        return damageDealt;
    }

    public int refillAmmo(int givenAmmo) {
        int remainingAmmo = Math.min(maxAmmo - currentAmmo, givenAmmo);
        currentAmmo += remainingAmmo;
        return givenAmmo - remainingAmmo;
    }

    public String getType() {
        return "";
    }

    public String getStatus() {
        return "Type " + getType() + ", Ammo: " + currentAmmo + ", Base Damage: " + baseDamage + ", All Damage: " + (baseDamage * currentAmmo);
    }

    public boolean isPriority() {
        return true;
    }

    public int getDamage() {
        return baseDamage * currentAmmo;
    }
}