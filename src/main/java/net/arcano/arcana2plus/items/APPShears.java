package net.arcano.arcana2plus.items;

import net.minecraft.block.*;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class APPShears extends ShearsItem {

    public APPShears(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();
        Hand hand = context.getHand();
        BlockPos pos = context.getBlockPos();

        if(state.isIn(BlockTags.BEEHIVES) && player != null || state.getBlock() == Blocks.PUMPKIN  && player != null) {
            if (state.isIn(BlockTags.BEEHIVES)) {
                int i = state.get(BeehiveBlock.HONEY_LEVEL);
                if (i >= 5) {
                    world.playSound(player, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    BeehiveBlock.dropHoneycomb(context.getWorld(), context.getBlockPos());
                    ((BeehiveBlock)state.getBlock()).takeHoney(world, state, pos, null, BeehiveBlockEntity.BeeState.BEE_RELEASED);
                    stack.damage(1, player, (playerEntity) -> player.sendToolBreakStatus(hand));
                }
            } else {
                if (!world.isClient) {
                    Direction direction = context.getSide();
                    Direction direction2 = direction.getAxis() == Direction.Axis.Y ? player.getHorizontalFacing().getOpposite() : direction;
                    world.playSound(null, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.setBlockState(pos, Blocks.CARVED_PUMPKIN.getDefaultState().with(CarvedPumpkinBlock.FACING, direction2), 11);
                    ItemEntity itemEntity = new ItemEntity(world, (double) pos.getX() + 0.5D + (double) direction2.getOffsetX() * 0.65D,
                            (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D + (double) direction2.getOffsetZ() * 0.65D,
                            new ItemStack(Items.PUMPKIN_SEEDS, 4));
                    itemEntity.setVelocity(0.05D * (double) direction2.getOffsetX() + world.random.nextDouble() * 0.02D,
                            0.05D, 0.05D * (double) direction2.getOffsetZ() + world.random.nextDouble() * 0.02D);
                    world.spawnEntity(itemEntity);
                    stack.damage(1, player, (playerEntity) -> playerEntity.sendToolBreakStatus(hand));
                }
            }
            return ActionResult.SUCCESS;
        }

        return super.useOnBlock(context);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        if(!entity.isSpectator() && entity instanceof Shearable) {
            Shearable target = (Shearable) entity;
            if (!entity.world.isClient && target.isShearable()) {
                ((Shearable) entity).sheared(SoundCategory.PLAYERS);
                stack.damage(1, user, (Consumer<LivingEntity>) ((playerEntity) -> user.sendToolBreakStatus(hand)));
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.CONSUME;
            }
        }
       return super.useOnEntity(stack, user, entity, hand);
    }
    /*
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.isIn(BlockTags.LEAVES) ||
                state.getMaterial() == Material.REPLACEABLE_PLANT && !(state.getBlock() instanceof TallFlowerBlock) ||
                state.getMaterial() == Material.REPLACEABLE_UNDERWATER_PLANT || state.getBlock() == Blocks.COBWEB ||
                state.getBlock() == Blocks.NETHER_SPROUTS)
        {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
                    new ItemStack(state.getBlock().asItem(), state.getBlock().getName().toString().contains("tall")? 2:1));
            world.spawnEntity(itemEntity);
        }
        return super.postMine(stack, world, state, pos, miner);
    }
    */
}
