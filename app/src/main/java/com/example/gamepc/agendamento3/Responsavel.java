package com.example.gamepc.agendamento3;

/**
 * Created by GamePC on 25/01/2017.
 */
public class Responsavel {
    private Long id;

    private String Nome;
    private String Matricula;
    private String Email;
    private String User;
    private String Senha;
    private String ConfirmaSenha;

    public String getConfirmaSenha() {
        return ConfirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        ConfirmaSenha = confirmaSenha;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
