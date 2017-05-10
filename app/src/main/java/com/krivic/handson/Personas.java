package com.krivic.handson;

/**
 * Created by Emilio on 29/11/2016.
 */

public class Personas {

    private int _id;
    private String _nombre;
    private String _apellido;
    private int _dni;               // se cambio edad por dni
    private String _telefono;
    private String _email;
    private String _motivo;
    private String _sexo;

    //private String _desestresarce;  // se agrego por lo del radio button
    //private String _aliviar;        // se agrego por lo del radio button
    //private String _reducir;        // se agrego por lo del radio button
    //private String  _tiposangre;


    public Personas(String nombre, String apellido, int dni, String telefono, String email, String motivo, String sexo) {// se cambio edad por dni  // se borro , String tiposangre
        this._nombre = nombre;
        this._apellido = apellido;
        this._dni = dni;            // se cambio edad por dni
        this._telefono = telefono;
        this._email = email;
        this._motivo = motivo;
        this._sexo= sexo;
        /*this._desestresarce= desestresarce;  // se agrego por lo del radio button
        this._aliviar= aliviar;              // se agrego por lo del radio button
        this._reducir= reducir;*/              // se agrego por lo del radio button
        //this._tiposangre = tiposangre;
    }




    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_apellido() {
        return _apellido;
    }

    public void set_apellido(String _apellido) {
        this._apellido = _apellido;
    }

    public int get_dni() {
        return _dni;
    }

    public void set_dni(int _dni) {
        this._dni = _dni;
    }

    public String get_telefono() {
        return _telefono;
    }

    public void set_telefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_motivo() {
        return _motivo;
    }

    public void set_motivo(String _motivo) {
        this._motivo = _motivo;
    }


    public String get_sexo() {return _sexo;
    }

    public void set_sexo(String _sexo) {this._sexo = _sexo;
    }
    /*public String get_desestresarce() {
        return _desestresarce;
    }

    public void set_desestresarce(String _desestresarce) {
        this._motivo = _desestresarce;
    }

    public String get_aliviar() {
        return _aliviar;
    }

    public void set_aliviar(String _aliviar) {
        this._motivo = _aliviar;
    }

    public String get_reducir() {
        return _reducir;
    }

    public void set_reducir(String _reducir) {
        this._motivo = _reducir;
    }

    // public String get_tiposangre() {        return _tiposangre;    }

    //public void set_tiposangre(String _tiposangre) {       this._tiposangre = _tiposangre;    }*/
}
