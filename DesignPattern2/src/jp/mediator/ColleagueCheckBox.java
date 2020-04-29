package jp.mediator;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.TextEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckBox extends Checkbox implements ItemListener, SampleColleague {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1L;

	private Mediator mediator;

	public ColleagueCheckBox(String caption, CheckboxGroup group, boolean stete) {
		super(caption, group, stete);
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

	public void textValueChanged(TextEvent event) {
		mediator.colleagueChanged();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		mediator.colleagueChanged();
	}
}