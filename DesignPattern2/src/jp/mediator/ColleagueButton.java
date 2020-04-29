package jp.mediator;

import java.awt.Button;

public class ColleagueButton extends Button implements SampleColleague {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1L;

	private Mediator mediator;

	public ColleagueButton(String caption) {
		super(caption);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		// TODO Auto-generated method stub
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		setEnabled(enabled);
	}

}