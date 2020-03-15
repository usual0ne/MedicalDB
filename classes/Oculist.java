package clinic.classes;

import clinic.abstractClasses.Doctor;

public class Oculist extends Doctor
{
    @Override
    public String examine()
    {
        this.randomConclusion = 1 + (int)(Math.random() * 5);
        switch (this.randomConclusion)
        {
            case 1:
                return ("keratoconus");
            case 2:
                return ("healthy eyes");
            case 3:
                return ("cataract");
            case 4:
                return ("conjunctivitis");
            case 5:
                return ("myopia");
            default:
                return ("The oculist " + " didn't come to a conclusion.");
        }
    }
}
