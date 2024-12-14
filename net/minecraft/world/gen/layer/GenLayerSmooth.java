package net.minecraft.world.gen.layer;

public class GenLayerSmooth extends GenLayer {
   public GenLayerSmooth(long p_i2131_1_, GenLayer p_i2131_3_) {
      super(p_i2131_1_);
      super.parent = p_i2131_3_;
   }

   public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
      int var5 = areaX - 1;
      int var6 = areaY - 1;
      int var7 = areaWidth + 2;
      int var8 = areaHeight + 2;
      int[] var9 = this.parent.getInts(var5, var6, var7, var8);
      int[] var10 = IntCache.getIntCache(areaWidth * areaHeight);

      for(int var11 = 0; var11 < areaHeight; ++var11) {
         for(int var12 = 0; var12 < areaWidth; ++var12) {
            int var13 = var9[var12 + 0 + (var11 + 1) * var7];
            int var14 = var9[var12 + 2 + (var11 + 1) * var7];
            int var15 = var9[var12 + 1 + (var11 + 0) * var7];
            int var16 = var9[var12 + 1 + (var11 + 2) * var7];
            int var17 = var9[var12 + 1 + (var11 + 1) * var7];
            if (var13 == var14 && var15 == var16) {
               this.initChunkSeed((long)(var12 + areaX), (long)(var11 + areaY));
               if (this.nextInt(2) == 0) {
                  var17 = var13;
               } else {
                  var17 = var15;
               }
            } else {
               if (var13 == var14) {
                  var17 = var13;
               }

               if (var15 == var16) {
                  var17 = var15;
               }
            }

            var10[var12 + var11 * areaWidth] = var17;
         }
      }

      return var10;
   }
}
