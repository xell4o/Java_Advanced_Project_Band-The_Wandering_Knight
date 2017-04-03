package game.states;

import game.Handler;
import gfx.Assets;
import gfx.ClickListener;
import gfx.UI.PauseManager;
import gfx.UI.UIImageButton;

import java.awt.*;

/**
 * Created by Home on 3/8/2017.
 */
public class PauseMenu extends State {
    private PauseManager pauseManager;


    public PauseMenu(Handler handler) {
        super(handler);
        pauseManager = new PauseManager(handler);

        handler.getMouseManager().setPauseManager(pauseManager);

        pauseManager.addObject(new UIImageButton(0, 0, 999, 556, Assets.startScreen, new ClickListener() {
            @Override
            public void onClick() {

            }
        }));
        pauseManager.addObject(new UIImageButton(900, 150, 52, 52, Assets.sound, new ClickListener() {
            @Override
            public void onClick() {
                handler.getGame().setMuted(!handler.getGame().isMuted());
                Assets.sound[0] = Assets.soundAlt[0];
                Assets.sound[1]= Assets.soundAlt[1];
                Assets.soundAlt[1] = Assets.sound[0];
                Assets.soundAlt[0]= Assets.sound[1];
            }
        }));
        pauseManager.addObject(new UIImageButton(800, 470, 198, 91, Assets.getMenuElement("btn_back"), new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);
                handler.getMouseManager().setPauseManager(null);

            }
        }));
        pauseManager.addObject(new UIImageButton(800, 50, 159, 107, Assets.getMenuElement("btn_quit"), new ClickListener() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));
    }

    @Override
    public void tick() {
        pauseManager.tick();
    }

    @Override
    public void render(Graphics g) {
        pauseManager.render(g);
    }
}
