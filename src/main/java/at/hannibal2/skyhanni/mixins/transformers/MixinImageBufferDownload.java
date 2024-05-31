package at.hannibal2.skyhanni.mixins.transformers;

import at.hannibal2.skyhanni.SkyHanniMod;
import net.minecraft.client.renderer.ImageBufferDownload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

@Mixin(ImageBufferDownload.class)
public abstract class MixinImageBufferDownload {
    @Shadow
    int[] imageData;

    @Shadow
    int imageWidth;

    @Shadow
    int imageHeight;

    @Shadow
    abstract void setAreaOpaque(int x, int y, int width, int height);

    @Shadow
    abstract void setAreaTransparent(int x, int y, int width, int height);

    // (C) SteveKunG - Skyblockcatia
    /**
     * @author minhperry
     * @reason Enable rendering of transparent skins
     */
    @Overwrite
    public BufferedImage parseUserSkin(BufferedImage image) {
        if (image == null) {
            return null;
        }
        else {
            if (!SkyHanniMod.getFeature().misc.transparentSkin) {
                this.imageHeight = 64;
                this.imageWidth = 64;
                BufferedImage bufferedImg = new BufferedImage(this.imageWidth, this.imageHeight, 2);
                Graphics graphics = bufferedImg.getGraphics();
                graphics.drawImage(image, 0, 0, null);

                if (image.getHeight() == 32) {
                    graphics.drawImage(bufferedImg, 24, 48, 20, 52, 4, 16, 8, 20, null);
                    graphics.drawImage(bufferedImg, 28, 48, 24, 52, 8, 16, 12, 20, null);
                    graphics.drawImage(bufferedImg, 20, 52, 16, 64, 8, 20, 12, 32, null);
                    graphics.drawImage(bufferedImg, 24, 52, 20, 64, 4, 20, 8, 32, null);
                    graphics.drawImage(bufferedImg, 28, 52, 24, 64, 0, 20, 4, 32, null);
                    graphics.drawImage(bufferedImg, 32, 52, 28, 64, 12, 20, 16, 32, null);
                    graphics.drawImage(bufferedImg, 40, 48, 36, 52, 44, 16, 48, 20, null);
                    graphics.drawImage(bufferedImg, 44, 48, 40, 52, 48, 16, 52, 20, null);
                    graphics.drawImage(bufferedImg, 36, 52, 32, 64, 48, 20, 52, 32, null);
                    graphics.drawImage(bufferedImg, 40, 52, 36, 64, 44, 20, 48, 32, null);
                    graphics.drawImage(bufferedImg, 44, 52, 40, 64, 40, 20, 44, 32, null);
                    graphics.drawImage(bufferedImg, 48, 52, 44, 64, 52, 20, 56, 32, null);
                    graphics.dispose();
                    this.imageData = ((DataBufferInt)bufferedImg.getRaster().getDataBuffer()).getData();
                    this.setAreaOpaque(0, 0, 32, 16);
                    this.setAreaTransparent(32, 0, 64, 32);
                    this.setAreaOpaque(0, 16, 64, 32);
                    this.setAreaTransparent(0, 32, 16, 48);
                    this.setAreaTransparent(16, 32, 40, 48);
                    this.setAreaTransparent(40, 32, 56, 48);
                    this.setAreaTransparent(0, 48, 16, 64);
                    this.setAreaOpaque(16, 48, 48, 64);
                    this.setAreaTransparent(48, 48, 64, 64);
                    return bufferedImg;
                }
                return image;
            }
            else {
                this.imageWidth = 64;
                this.imageHeight = 64;
                BufferedImage bufferedimage = new BufferedImage(this.imageWidth, this.imageHeight, 2);
                Graphics graphics = bufferedimage.getGraphics();
                graphics.drawImage(image, 0, 0, null);

                if (image.getHeight() == 32)
                {
                    graphics.drawImage(bufferedimage, 24, 48, 20, 52, 4, 16, 8, 20, null);
                    graphics.drawImage(bufferedimage, 28, 48, 24, 52, 8, 16, 12, 20, null);
                    graphics.drawImage(bufferedimage, 20, 52, 16, 64, 8, 20, 12, 32, null);
                    graphics.drawImage(bufferedimage, 24, 52, 20, 64, 4, 20, 8, 32, null);
                    graphics.drawImage(bufferedimage, 28, 52, 24, 64, 0, 20, 4, 32, null);
                    graphics.drawImage(bufferedimage, 32, 52, 28, 64, 12, 20, 16, 32, null);
                    graphics.drawImage(bufferedimage, 40, 48, 36, 52, 44, 16, 48, 20, null);
                    graphics.drawImage(bufferedimage, 44, 48, 40, 52, 48, 16, 52, 20, null);
                    graphics.drawImage(bufferedimage, 36, 52, 32, 64, 48, 20, 52, 32, null);
                    graphics.drawImage(bufferedimage, 40, 52, 36, 64, 44, 20, 48, 32, null);
                    graphics.drawImage(bufferedimage, 44, 52, 40, 64, 40, 20, 44, 32, null);
                    graphics.drawImage(bufferedimage, 48, 52, 44, 64, 52, 20, 56, 32, null);
                }
                graphics.dispose();
                this.imageData = ((DataBufferInt)bufferedimage.getRaster().getDataBuffer()).getData();
                this.setAreaOpaque(0, 0, 32, 16);
                this.setAreaTransparent(32, 0, 64, 32);
                this.setAreaOpaque(0, 16, 64, 32);
                this.setAreaTransparent(0, 32, 16, 48);
                this.setAreaTransparent(16, 32, 40, 48);
                this.setAreaTransparent(40, 32, 56, 48);
                this.setAreaTransparent(0, 48, 16, 64);
                this.setAreaOpaque(16, 48, 48, 64);
                this.setAreaTransparent(48, 48, 64, 64);
                return bufferedimage;
            }
        }
    }
}
