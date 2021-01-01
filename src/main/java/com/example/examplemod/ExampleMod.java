//package com.example.examplemod;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.RenderTypeLookup;
//import net.minecraft.entity.EntityClassification;
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
//import net.minecraft.entity.monster.ZombieEntity;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.text.StringTextComponent;
//import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.event.entity.player.PlayerEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.InterModComms;
//import net.minecraftforge.fml.RegistryObject;
//import net.minecraftforge.fml.client.registry.RenderingRegistry;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.registry.GameRegistry;
//import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
//import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
//import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.IForgeRegistry;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.util.stream.Collectors;
//
//// The value here should match an entry in the META-INF/mods.toml file
//@Mod("examplemod")
//public class ExampleMod
//{
//    static String MODID = "examplemod";
//    RegistryObject<Block> xray;
//    // Directly reference a log4j logger.
//    private static final Logger LOGGER = LogManager.getLogger();
//    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
//    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
//    static final DeferredRegister ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
//    RegistryObject<EntityType<Torpedo>> torpedo;
//    public ExampleMod() {
//        MinecraftForge.EVENT_BUS.register(new RegistryEvents());
//        // Register the setup method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//        // Register the doClientStuff method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
//
//        // Register ourselves for server and other game events we are interested in
////        MinecraftForge.EVENT_BUS.register(this);
//        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
//        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
//        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
//
////        ITEMS.register("xray",      ()-> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
//       xray = BLOCKS.register("xray", () -> new Block(
//                Block.Properties.create(Material.GLASS)
//        ));
//        ITEMS.register("xray", () -> new BlockItem(this.xray.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
//
//        torpedo = ENTITIES.register("torpedo", () -> EntityType.Builder
//                .create(Torpedo::new, EntityClassification.MONSTER)
//                .size(5f, 5f)
//                .build(new ResourceLocation(MODID, "torpedo").toString()));
//    }
//
//    private void setup(final FMLCommonSetupEvent event)
//    {
//
//        event.enqueueWork(()->{
//            RenderTypeLookup.setRenderLayer(xray.get(), RenderType.getTranslucent());
//
//            GlobalEntityTypeAttributes.put(torpedo.get(), Torpedo.setCustomAttributes().create());
//            RenderingRegistry.registerEntityRenderingHandler(torpedo.get(),
//                    TorpedoRender::new);
//        });
//    }
//
//    private void doClientStuff(final FMLClientSetupEvent event) {
//        // do something that can only be done on the client
//        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
//    }
//
//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
//    }
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//        // do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }
//
//    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
//    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public class RegistryEvents {
//        @SubscribeEvent
//        public void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//        @SubscribeEvent
//        public void onSpawn(final PlayerEvent.PlayerLoggedInEvent event) {
//            IForgeRegistry<Item> registry = GameRegistry.findRegistry(Item.class);
//            Item Airpods = registry.getValue(new ResourceLocation("minecraft:netherite_boots"));
//            Item NoStab = registry.getValue(new ResourceLocation("minecraft:netherite_chestplate"));
//            event.getPlayer().entityDropItem(new ItemStack(Airpods, 1));
//            event.getPlayer().entityDropItem(new ItemStack(NoStab, 1));
//            event.getPlayer().sendMessage(new StringTextComponent("Here."), event.getPlayer().getUniqueID());
//        }
//
//    }
//}
