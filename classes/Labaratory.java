package clinic.classes;

public class Labaratory
{
    public String getAnalysis(Patient patient)
    {
        switch (patient.getSex())
        {
            case "M":
                if (patient.getHemoglobin() < 161 && patient.getHemoglobin() > 134)
                {
                    return ("hemoglobin level is normal");
                }
                if (patient.getHemoglobin() < 135)
                {
                    return ("hemoglobin level is too low");
                }
                if (patient.getHemoglobin() > 160)
                {
                    return ("hemoglobin level is too high");
                }

            case "F":
                if (patient.getHemoglobin() < 141 && patient.getHemoglobin() > 119)
                {
                    return ("hemoglobin level is normal");
                }
                if (patient.getHemoglobin() < 120)
                {
                    return ("hemoglobin level is too low");
                }
                if (patient.getHemoglobin() > 140)
                {
                    return ("hemoglobin level is too high");
                }

            default:
                return "Not a male or a female!";
        }
    }
}
