package entities.statics;

import game.Handler;
import gfx.Assets;
import items.Item;

import java.awt.*;
//AY
public class Tent extends StaticEntity {

    private static final int TENT_WIDTH = 60, TENT_HEIGHT = 60;

    public Tent(Handler handler, float x, float y) {
        super(handler, x, y, TENT_WIDTH, TENT_HEIGHT);

        bounds.x = 20;
        bounds.y = 92;
        bounds.width = 22;
        bounds.height = 1;
    }

    @Override
    public void tick() {

    }

    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.key.createNew((int) x, (int) y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tent, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera
                ().getyOffset()), width, height, null);
    }
}