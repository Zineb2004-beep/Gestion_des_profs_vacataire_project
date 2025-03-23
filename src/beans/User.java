/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author zineb
 */
public class User {

    private String login;
    private String password;
    private String questionSecurit;
    private String reponseSecurit;
    private String email;

    public User(String login, String password, String questionSecurit, String reponseSecurit, String email) {
        this.login = login;
        this.password = password;

        this.questionSecurit = questionSecurit;
        this.reponseSecurit = reponseSecurit;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestionSecurit() {
        return questionSecurit;
    }

    public void setQuestionSecurit(String questionSecurit) {
        this.questionSecurit = questionSecurit;
    }

    public String getReponseSecurit() {
        return reponseSecurit;
    }

    public void setReponseSecurit(String reponseSecurit) {
        this.reponseSecurit = reponseSecurit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "login=" + login + ", password=" + password + ", securityQuestion=" + questionSecurit + ", securityAnswer=" + reponseSecurit + ", email=" + email + '}';
    }

}