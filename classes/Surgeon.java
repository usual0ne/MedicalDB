package clinic.classes;

import clinic.abstractClasses.Doctor;

public class Surgeon extends Doctor
{
    @Override
    public String examine()
    {
        this.randomConclusion = 1 + (int)(Math.random() * 5);
        switch (this.randomConclusion)
        {
            case 1:
                return ("deep rib cage injury");
            case 2:
                return ("tailbone is broken");
            case 3:
                return ("appendicitis");
            case 4:
                return ("no serious injuries");
            case 5:
                return ("right leg is broken");
            default:
                return ("The surgeon " + " didn't come to a conclusion");
            }
    }
}
