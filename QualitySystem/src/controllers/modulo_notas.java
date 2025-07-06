package controllers;

public class modulo_notas {
    float Nota1;
    float Nota2;
    float Nota3;

    public void Asignar_Nota(float Nota1, float Nota2, float Nota3) {
         if (validacion(Nota1) && validacion(Nota2) && validacion(Nota3)) {
        this.Nota1 = Nota1;
        this.Nota2 = Nota2;
        this.Nota3 = Nota3;
    }
}

    public float Calcular_promedio() {
        float Notafinal = (Nota1 + Nota2 + Nota3) / 3;
        return (Notafinal);
    }
private boolean validacion (float nota){
    return nota >= 0 && nota <= 10;
}

}




