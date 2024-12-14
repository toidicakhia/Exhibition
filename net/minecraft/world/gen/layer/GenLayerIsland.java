package net.minecraft.world.gen.layer;

public class GenLayerIsland extends GenLayer {
   public GenLayerIsland(long p_i2124_1_) {
      super(p_i2124_1_);
   }

   public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
      int[] var5 = IntCache.getIntCache(areaWidth * areaHeight);

      for(int var6 = 0; var6 < areaHeight; ++var6) {
         for(int var7 = 0; var7 < areaWidth; ++var7) {
            this.initChunkSeed((long)(areaX + var7), (long)(areaY + var6));
            var5[var7 + var6 * areaWidth] = this.nextInt(10) == 0 ? 1 : 0;
         }
      }

      if (areaX > -areaWidth && areaX <= 0 && areaY > -areaHeight && areaY <= 0) {
         var5[-areaX + -areaY * areaWidth] = 1;
      }

      return var5;
   }
}