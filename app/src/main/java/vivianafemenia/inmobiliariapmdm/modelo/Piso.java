package vivianafemenia.inmobiliariapmdm.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Piso implements Parcelable {

    private String direccion;
    private int numero;
    private String cuidad;
    private String provincia;
    private String cp;
    private float valoracion;

    public Piso() {
    }

    public Piso(String direccion, int numero, String cuidad, String provincia, String cp, float valoracion) {
        this.direccion = direccion;
        this.numero = numero;
        this.cuidad = cuidad;
        this.provincia = provincia;
        this.cp = cp;
        this.valoracion = valoracion;
    }

    protected Piso(Parcel in) {
        direccion = in.readString();
        numero = in.readInt();
        cuidad = in.readString();
        provincia = in.readString();
        cp = in.readString();
        valoracion = in.readFloat();
    }

    public static final Creator<Piso> CREATOR = new Creator<Piso>() {
        @Override
        public Piso createFromParcel(Parcel in) {
            return new Piso(in);
        }

        @Override
        public Piso[] newArray(int size) {
            return new Piso[size];
        }
    };

    public Piso(String toString, String toString1, String toString2, String toString3) {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Piso{" +
                "direccion='" + direccion + '\'' +
                ", numero=" + numero +
                ", cuidad='" + cuidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", cp='" + cp + '\'' +
                ", valoracion=" + valoracion +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(direccion);
        parcel.writeInt(numero);
        parcel.writeString(cuidad);
        parcel.writeString(provincia);
        parcel.writeString(cp);
        parcel.writeFloat(valoracion);
    }
}
