package exhibition.tails.impl;

import exhibition.tails.ModelPartBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;

public class ModelCatEars extends ModelPartBase {
   final ModelRenderer leftEarBottom;
   final ModelRenderer leftEarRearTop;
   final ModelRenderer leftEarRearLayer1;
   final ModelRenderer leftEarRearBottom;
   final ModelRenderer leftEarLayer1;
   final ModelRenderer leftEarTop;
   final ModelRenderer leftEarLayer3;
   final ModelRenderer leftEarLayer2;
   final ModelRenderer rightEarBottom;
   final ModelRenderer rightEarLayer1;
   final ModelRenderer rightEarRearTop;
   final ModelRenderer rightEarRearLayer1;
   final ModelRenderer rightEarRearBottom;
   final ModelRenderer rightEarLayer2;
   final ModelRenderer rightEarTop;
   final ModelRenderer rightEarLayer3;

   public ModelCatEars() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.leftEarBottom = new ModelRenderer(this, 0, 0);
      this.leftEarBottom.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.leftEarBottom.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarBottom.setTextureSize(64, 32);
      this.leftEarBottom.mirror = true;
      this.leftEarRearTop = new ModelRenderer(this, 0, 16);
      this.leftEarRearTop.addBox(0.0F, -3.0F, 1.0F, 1, 1, 1);
      this.leftEarRearTop.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarRearTop.setTextureSize(64, 32);
      this.leftEarRearTop.mirror = true;
      this.leftEarRearLayer1 = new ModelRenderer(this, 0, 14);
      this.leftEarRearLayer1.addBox(-1.0F, -2.0F, 1.0F, 2, 1, 1);
      this.leftEarRearLayer1.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarRearLayer1.setTextureSize(64, 32);
      this.leftEarRearLayer1.mirror = true;
      this.leftEarRearBottom = new ModelRenderer(this, 0, 12);
      this.leftEarRearBottom.addBox(-2.0F, -1.0F, 1.0F, 3, 1, 1);
      this.leftEarRearBottom.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarRearBottom.setTextureSize(64, 32);
      this.leftEarRearBottom.mirror = true;
      this.leftEarLayer1 = new ModelRenderer(this, 0, 2);
      this.leftEarLayer1.addBox(-3.0F, -1.0F, 0.0F, 5, 1, 1);
      this.leftEarLayer1.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarLayer1.setTextureSize(64, 32);
      this.leftEarLayer1.mirror = true;
      this.leftEarTop = new ModelRenderer(this, 0, 8);
      this.leftEarTop.addBox(0.0F, -4.0F, 0.0F, 1, 1, 1);
      this.leftEarTop.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarTop.setTextureSize(64, 32);
      this.leftEarTop.mirror = true;
      this.leftEarLayer3 = new ModelRenderer(this, 0, 6);
      this.leftEarLayer3.addBox(-1.0F, -3.0F, 0.0F, 3, 1, 1);
      this.leftEarLayer3.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarLayer3.setTextureSize(64, 32);
      this.leftEarLayer3.mirror = true;
      this.leftEarLayer2 = new ModelRenderer(this, 0, 4);
      this.leftEarLayer2.addBox(-2.0F, -2.0F, 0.0F, 4, 1, 1);
      this.leftEarLayer2.setRotationPoint(4.0F, -8.0F, 0.0F);
      this.leftEarLayer2.setTextureSize(64, 32);
      this.leftEarLayer2.mirror = true;
      this.rightEarBottom = new ModelRenderer(this, 13, 0);
      this.rightEarBottom.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1);
      this.rightEarBottom.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarBottom.setTextureSize(64, 32);
      this.rightEarBottom.mirror = true;
      this.rightEarLayer1 = new ModelRenderer(this, 13, 2);
      this.rightEarLayer1.addBox(-2.0F, -1.0F, 0.0F, 5, 1, 1);
      this.rightEarLayer1.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarLayer1.setTextureSize(64, 32);
      this.rightEarLayer1.mirror = true;
      this.rightEarRearTop = new ModelRenderer(this, 13, 16);
      this.rightEarRearTop.addBox(-1.0F, -3.0F, 1.0F, 1, 1, 1);
      this.rightEarRearTop.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarRearTop.setTextureSize(64, 32);
      this.rightEarRearTop.mirror = true;
      this.rightEarRearLayer1 = new ModelRenderer(this, 13, 14);
      this.rightEarRearLayer1.addBox(-1.0F, -2.0F, 1.0F, 2, 1, 1);
      this.rightEarRearLayer1.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarRearLayer1.setTextureSize(64, 32);
      this.rightEarRearLayer1.mirror = true;
      this.rightEarRearBottom = new ModelRenderer(this, 13, 12);
      this.rightEarRearBottom.addBox(-1.0F, -1.0F, 1.0F, 3, 1, 1);
      this.rightEarRearBottom.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarRearBottom.setTextureSize(64, 32);
      this.rightEarRearBottom.mirror = true;
      this.rightEarLayer2 = new ModelRenderer(this, 13, 4);
      this.rightEarLayer2.addBox(-2.0F, -2.0F, 0.0F, 4, 1, 1);
      this.rightEarLayer2.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarLayer2.setTextureSize(64, 32);
      this.rightEarLayer2.mirror = true;
      this.rightEarTop = new ModelRenderer(this, 13, 8);
      this.rightEarTop.addBox(-1.0F, -4.0F, 0.0F, 1, 1, 1);
      this.rightEarTop.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarTop.setTextureSize(64, 32);
      this.rightEarTop.mirror = true;
      this.rightEarLayer3 = new ModelRenderer(this, 13, 6);
      this.rightEarLayer3.addBox(-2.0F, -3.0F, 0.0F, 3, 1, 1);
      this.rightEarLayer3.setRotationPoint(-4.0F, -8.0F, 0.0F);
      this.rightEarLayer3.setTextureSize(64, 32);
      this.rightEarLayer3.mirror = true;
   }

   public void render(EntityLivingBase theEntity, int subtype, float partialTicks) {
      this.leftEarBottom.render(0.0635F);
      this.leftEarRearTop.render(0.0635F);
      this.leftEarRearLayer1.render(0.0635F);
      this.leftEarRearBottom.render(0.0635F);
      this.leftEarLayer1.render(0.0635F);
      this.leftEarTop.render(0.0635F);
      this.leftEarLayer3.render(0.0635F);
      this.leftEarLayer2.render(0.0635F);
      this.rightEarBottom.render(0.0635F);
      this.rightEarLayer1.render(0.0635F);
      this.rightEarRearTop.render(0.0635F);
      this.rightEarRearLayer1.render(0.0635F);
      this.rightEarRearBottom.render(0.0635F);
      this.rightEarLayer2.render(0.0635F);
      this.rightEarTop.render(0.0635F);
      this.rightEarLayer3.render(0.0635F);
   }
}