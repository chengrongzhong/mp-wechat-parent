package com.qq.bean.menu;

import com.weixin.common.bean.BaseResult;

/**
 * 菜单由MenuButton数组组成
 */
public class Menu {

	private MenuButton[] button;


	public MenuButton[] getButton() {
		return button;
	}

	public void setButton(MenuButton[] button) {
		this.button = button;
	}

	public Menu(){

	}

	public Menu(MenuButton[] button){
		this.button = button;
	}
	
	
}
