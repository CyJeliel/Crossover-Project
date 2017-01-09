package com.crossover.project.web.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.crossover.project.application.IUsuarioApplication;
import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.StatusCredencialEnum;

import lombok.Getter;
import lombok.Setter;

@SessionScoped
@ManagedBean(name = "registroMBean")
public class RegistroMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String EMPTY = "";

	@Getter
	@Setter
	private String login;

	@Getter
	@Setter
	private String senha;

	@Getter
	@Setter
	private String confirmacaoSenha;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private String feedback;

	@Getter
	@Setter
	private String tipoFeedback;

	@EJB
	private transient IUsuarioApplication registroSC;

	/**
	 * Limpa os campos da sessão.
	 */
	public void reset() {

		setLogin(EMPTY);

		senha = EMPTY;
	}

	public String pagRegistrar() {

		return "/public/registroUsuario";
	}

	/**
	 * Login no StarTeam
	 * 
	 * @param request
	 * @param context
	 * @return
	 */
	public String registrar() {

		User usuario = new User();

		usuario.setLogin(login);

		usuario.setSenha(senha);

		usuario.setConfirmacaoSenha(confirmacaoSenha);

		usuario.setNome(nome);

		StatusCredencialEnum status = registroSC.registrar(usuario);

		feedback = status.getFeedback();

		tipoFeedback = status.getTipoFeedback();

		return "";
	}
}
