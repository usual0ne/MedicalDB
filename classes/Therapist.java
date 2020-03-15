package clinic.classes;

import clinic.abstractClasses.Doctor;

public class Therapist extends Doctor
{
    @Override
    public String examine()
    {
        this.randomConclusion = 1 + (int)(Math.random() * 5);
        switch (this.randomConclusion)
        {
            case 1:
                return ("chickenpox");
            case 2:
                return ("hypertension");
            case 3:
                return ("no diseases");
            case 4:
                return ("pneumonia");
            case 5:
                return ("gastritis");
            default:
                return ("The therapist " + " didn't come to a conclusion");
        }
    }
}
