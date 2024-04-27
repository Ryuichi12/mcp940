import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class InventoryBasic<T extends ItemStack> implements IInventory {

    private String inventoryTitle;
    private final int slotsCount;
    private final List<T> inventoryContents;
    private List<IInventoryChangedListener> changeListeners;
    private boolean hasCustomName;

    /**
     *  Constructor
     * @param title Inventory title
     * @param customName Indicates if the inventory has a custom name 
     * @param slotCount Number of slots in the inventory
     */
    public InventoryBasic(String title, boolean customName, int slotCount) {
        this.inventoryTitle = title;
        this.hasCustomName = customName;
        this.slotsCount = slotCount;
        this.inventoryContents = new ArrayList<>(slotCount); 
        for (int i = 0; i < slotCount; ++i) {
            inventoryContents.add(null); 
        }
    }

    public InventoryBasic(ITextComponent title, int slotCount) {
        this(title.getUnformattedText(), true, slotCount);
    }

    // ... Other methods: addInventoryChangeListener, removeInventoryChangeListener ...

   /**
    * Returns the stack in the given slot.
    * @param index The slot index
    * @return The ItemStack in the slot, or null if the slot is empty or the index is invalid
    * @throws IndexOutOfBoundsException if the index is out of bounds
    */
    public T getStackInSlot(int index) {
        if (index >= 0 && index < this.inventoryContents.size()) {
            return this.inventoryContents.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid slot index"); 
        }
    }

    // ... Implement the rest of the methods from the IInventory interface ...

    // ... Consider refactoring other methods similarly for generics, 
    // ... error handling, and potential data structure changes ...
}
