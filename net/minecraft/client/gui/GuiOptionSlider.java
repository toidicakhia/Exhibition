package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MathHelper;

public class GuiOptionSlider extends GuiButton {
   private float sliderValue;
   public boolean dragging;
   private GameSettings.Options options;
   private final float field_146132_r;
   private final float field_146131_s;

   public GuiOptionSlider(int p_i45016_1_, int p_i45016_2_, int p_i45016_3_, GameSettings.Options p_i45016_4_) {
      this(p_i45016_1_, p_i45016_2_, p_i45016_3_, p_i45016_4_, 0.0F, 1.0F);
   }

   public GuiOptionSlider(int p_i45017_1_, int p_i45017_2_, int p_i45017_3_, GameSettings.Options p_i45017_4_, float p_i45017_5_, float p_i45017_6_) {
      super(p_i45017_1_, p_i45017_2_, p_i45017_3_, 150, 20, "");
      this.sliderValue = 1.0F;
      this.options = p_i45017_4_;
      this.field_146132_r = p_i45017_5_;
      this.field_146131_s = p_i45017_6_;
      Minecraft var7 = Minecraft.getMinecraft();
      this.sliderValue = p_i45017_4_.normalizeValue(var7.gameSettings.getOptionFloatValue(p_i45017_4_));
      this.displayString = var7.gameSettings.getKeyBinding(p_i45017_4_);
   }

   protected int getHoverState(boolean mouseOver) {
      return 0;
   }

   protected void mouseDragged(Minecraft mc, int mouseX, int mouseY) {
      if (this.visible) {
         if (this.dragging) {
            this.sliderValue = (float)(mouseX - (this.xPosition + 4)) / (float)(this.width - 8);
            this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0F, 1.0F);
            float var4 = this.options.denormalizeValue(this.sliderValue);
            mc.gameSettings.setOptionFloatValue(this.options, var4);
            this.sliderValue = this.options.normalizeValue(var4);
            this.displayString = mc.gameSettings.getKeyBinding(this.options);
         }

         mc.getTextureManager().bindTexture(buttonTextures);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)), this.yPosition, 0, 66, 4, 20);
         this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
      }

   }

   public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
      if (super.mousePressed(mc, mouseX, mouseY)) {
         this.sliderValue = (float)(mouseX - (this.xPosition + 4)) / (float)(this.width - 8);
         this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0F, 1.0F);
         mc.gameSettings.setOptionFloatValue(this.options, this.options.denormalizeValue(this.sliderValue));
         this.displayString = mc.gameSettings.getKeyBinding(this.options);
         this.dragging = true;
         return true;
      } else {
         return false;
      }
   }

   public void mouseReleased(int mouseX, int mouseY) {
      this.dragging = false;
   }
}
