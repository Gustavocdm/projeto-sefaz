package com.sefaz.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.sefaz.model.Usuario;

@Named
@SessionScoped
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	private String usuarioNome;
	private String senha;
	
	public String login() {
		System.out.println("Chamou corretamente login()!");
		FacesContext context = FacesContext.getCurrentInstance();
		if(usuarioNome.equals("u") && senha.equals("s")) {
			usuario = new Usuario();
			return "/restrito/index.xhtml?faces-redirect=true";
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e/ou senha inválido(s).", ""));
		return null;
	}
	
	public String logout() {
		System.out.println("Entrou no logout!");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		usuario = null;
		return "/login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean estaLogado() {
		return usuario != null;
	}
	
}
