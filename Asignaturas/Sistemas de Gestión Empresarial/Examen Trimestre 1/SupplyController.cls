public with sharing class SupplyController 
{
    private String sortOrder = 'Total_Cost__c';

    public List<Supply__c> getArticulos() 
    {
       List<Supply__c> articulos =Database.query('SELECT Name, Quantity__c, Total_Cost__c, Unit_cost__c, Battle_Station__c, CreatedById from Supply__c order by '+ sortOrder +' desc');
       return articulos;
    }
    public void sortByName()
    {
        this.sortOrder = 'Name';
    }
    public void sortByQuantity()
    {
        this.sortOrder = 'Quantity__c';
    }
    public void sortByTotalCost()
    {
        this.sortOrder = 'Total_Cost__c';
    }
    public void sortByUnitCost()
    {
        this.sortOrder = 'Unit_Cost__c';
    }
    public void sortByBattleStation()
    {
        this.sortOrder = 'Battle_Station__c';
    }
}
