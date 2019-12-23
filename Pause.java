package com.gcstudios.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Pause {

public String[] options = {"continuar","salvar jogo","voltar para menu"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up,down,enter;
	
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}
		if(enter) {
			enter = false;
			if(options[currentOption] == "continuar") {
				Game.gameState = "NORMAL";
			}else if(options[currentOption] == "salvar jogo") {
				
			}else if(options[currentOption] == "voltar para menu") {
				Game.gameState = "MENU";
			}
		}
	}

	//Pause render
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,150));
		g2.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial",Font.BOLD,36));
		g.drawString("PAUSE", (Game.WIDTH*Game.SCALE) / 2 - 53, (Game.HEIGHT*Game.SCALE) / 2 - 160);
		
		//Pause options
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,24));
		g.drawString("Continuar", (Game.WIDTH*Game.SCALE) / 2 - 49, 160);
		g.drawString("Salvar jogo", (Game.WIDTH*Game.SCALE) / 2 - 57, 200);
		g.drawString("Voltar para menu", (Game.WIDTH*Game.SCALE) / 2 - 89, 240);
		
		//Option indicator
		if(options[currentOption] == "continuar") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 68, 160);
		}else if(options[currentOption] == "salvar jogo") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 76, 200);
		}else if(options[currentOption] == "voltar para menu") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 - 108, 240);
		}
	}
	
}
