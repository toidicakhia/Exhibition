package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOldLeaf extends BlockLeaves {
   public static final PropertyEnum VARIANT_PROP = PropertyEnum.create("variant", BlockPlanks.EnumType.class, new Predicate() {
      public boolean func_180202_a(BlockPlanks.EnumType p_180202_1_) {
         return p_180202_1_.func_176839_a() < 4;
      }

      public boolean apply(Object p_apply_1_) {
         return this.func_180202_a((BlockPlanks.EnumType)p_apply_1_);
      }
   });

   public BlockOldLeaf() {
      this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT_PROP, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.field_176236_b, true).withProperty(BlockLeaves.field_176237_a, true));
   }

   public int getRenderColor(IBlockState state) {
      if (state.getBlock() != this) {
         return super.getRenderColor(state);
      } else {
         BlockPlanks.EnumType var2 = (BlockPlanks.EnumType)state.getValue(VARIANT_PROP);
         return var2 == BlockPlanks.EnumType.SPRUCE ? ColorizerFoliage.getFoliageColorPine() : (var2 == BlockPlanks.EnumType.BIRCH ? ColorizerFoliage.getFoliageColorBirch() : super.getRenderColor(state));
      }
   }

   public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
      IBlockState var4 = worldIn.getBlockState(pos);
      if (var4.getBlock() == this) {
         BlockPlanks.EnumType var5 = (BlockPlanks.EnumType)var4.getValue(VARIANT_PROP);
         if (var5 == BlockPlanks.EnumType.SPRUCE) {
            return ColorizerFoliage.getFoliageColorPine();
         }

         if (var5 == BlockPlanks.EnumType.BIRCH) {
            return ColorizerFoliage.getFoliageColorBirch();
         }
      }

      return super.colorMultiplier(worldIn, pos, renderPass);
   }

   protected void func_176234_a(World worldIn, BlockPos p_176234_2_, IBlockState p_176234_3_, int p_176234_4_) {
      if (p_176234_3_.getValue(VARIANT_PROP) == BlockPlanks.EnumType.OAK && worldIn.rand.nextInt(p_176234_4_) == 0) {
         Block.spawnAsEntity(worldIn, p_176234_2_, new ItemStack(Items.apple, 1, 0));
      }

   }

   protected int func_176232_d(IBlockState p_176232_1_) {
      return p_176232_1_.getValue(VARIANT_PROP) == BlockPlanks.EnumType.JUNGLE ? 40 : super.func_176232_d(p_176232_1_);
   }

   public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
      list.add(new ItemStack(itemIn, 1, BlockPlanks.EnumType.OAK.func_176839_a()));
      list.add(new ItemStack(itemIn, 1, BlockPlanks.EnumType.SPRUCE.func_176839_a()));
      list.add(new ItemStack(itemIn, 1, BlockPlanks.EnumType.BIRCH.func_176839_a()));
      list.add(new ItemStack(itemIn, 1, BlockPlanks.EnumType.JUNGLE.func_176839_a()));
   }

   protected ItemStack createStackedBlock(IBlockState state) {
      return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)state.getValue(VARIANT_PROP)).func_176839_a());
   }

   public IBlockState getStateFromMeta(int meta) {
      return this.getDefaultState().withProperty(VARIANT_PROP, this.func_176233_b(meta)).withProperty(BlockLeaves.field_176237_a, (meta & 4) == 0).withProperty(BlockLeaves.field_176236_b, (meta & 8) > 0);
   }

   public int getMetaFromState(IBlockState state) {
      byte var2 = 0;
      int var3 = var2 | ((BlockPlanks.EnumType)state.getValue(VARIANT_PROP)).func_176839_a();
      if (!((Boolean)state.getValue(BlockLeaves.field_176237_a)).booleanValue()) {
         var3 |= 4;
      }

      if (((Boolean)state.getValue(BlockLeaves.field_176236_b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public BlockPlanks.EnumType func_176233_b(int p_176233_1_) {
      return BlockPlanks.EnumType.func_176837_a((p_176233_1_ & 3) % 4);
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{VARIANT_PROP, BlockLeaves.field_176236_b, BlockLeaves.field_176237_a});
   }

   public int damageDropped(IBlockState state) {
      return ((BlockPlanks.EnumType)state.getValue(VARIANT_PROP)).func_176839_a();
   }

   public void harvestBlock(World worldIn, EntityPlayer playerIn, BlockPos pos, IBlockState state, TileEntity te) {
      if (!worldIn.isRemote && playerIn.getCurrentEquippedItem() != null && playerIn.getCurrentEquippedItem().getItem() == Items.shears) {
         playerIn.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
         Block.spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(this), 1, ((BlockPlanks.EnumType)state.getValue(VARIANT_PROP)).func_176839_a()));
      } else {
         super.harvestBlock(worldIn, playerIn, pos, state, te);
      }

   }
}
