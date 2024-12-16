package net.beeparty.voelkerball.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder
{

    private ItemStack item;
    private List<String> lore = new ArrayList<>();
    private ItemMeta meta;

    public ItemBuilder(Material mat, short subid, int amount)
    {
        item = new ItemStack(mat, amount, subid);
        meta = item.getItemMeta();
    }

    public ItemBuilder(ItemStack item)
    {
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public ItemBuilder(Material mat, short subid)
    {
        item = new ItemStack(mat, 1, subid);
        meta = item.getItemMeta();
    }

    public ItemBuilder(Material mat, int amount)
    {
        item = new ItemStack(mat, amount, (short) 0);
        meta = item.getItemMeta();
    }

    public ItemBuilder(Material mat)
    {
        item = new ItemStack(mat, 1, (short) 0);
        meta = item.getItemMeta();
    }

    public ItemBuilder setAmount(int value)
    {
        item.setAmount(value);
        return this;
    }

    public ItemBuilder setNoName()
    {
        meta.setDisplayName(" ");
        return this;
    }

    public ItemBuilder setData(short data)
    {
        item.setDurability(data);
        return this;
    }

    public ItemBuilder addLoreLine(String line)
    {
        lore.add(line);
        return this;
    }

    public ItemBuilder addLoreArray(String[] lines)
    {
        for (int x = 0; x < lines.length; x++)
        {
            lore.add(lines[x]);
        }
        return this;
    }

    public ItemBuilder addLoreAll(List<String> lines)
    {
        lore.addAll(lines);
        return this;
    }

    public ItemBuilder setDisplayName(String name)
    {
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setSkullOwner(String owner)
    {
        ((SkullMeta) meta).setOwner(owner);
        return this;
    }

    public ItemBuilder setColor(Color c)
    {
        ((LeatherArmorMeta) meta).setColor(c);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean value)
    {
        meta.setUnbreakable(true);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment ench, int lvl)
    {
        meta.addEnchant(ench, lvl, true);
        return this;
    }

    public ItemBuilder addItemFlag(ItemFlag flag)
    {
        meta.addItemFlags(flag);
        return this;
    }

    public ItemBuilder addLeatherColor(Color color)
    {
        ((LeatherArmorMeta) meta).setColor(color);
        return this;
    }

    public ItemStack build()
    {
        if (lore.isEmpty() == false)
        {
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getPlayerSkull(Player player, String name) {
        ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(player.getName());
        meta.setDisplayName(name);
        skull.setItemMeta(meta);
        return skull;
    }

    public static ItemStack createFireworkCharge(String name, Color color){

        ItemStack playerDrop = new ItemStack( Material.LEGACY_FIREWORK_CHARGE, 1);
        ItemMeta meta = playerDrop.getItemMeta();
        FireworkEffectMeta metaFw = (FireworkEffectMeta) meta;
        FireworkEffect aa = FireworkEffect.builder().withColor(color).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(name);
        playerDrop.setItemMeta(metaFw);

        return playerDrop;
    }



}

