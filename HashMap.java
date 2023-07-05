import java.util.ArrayList;
import java.util.List;
public class HashMap<K,V> {
   //private List<<K,V>>[] values; 
   private ArrayList<Pair<K,V>>[] values;
   private int nextFreeIndex;
   
   public HashMap(){
        this.values = new ArrayList[32];
        this.nextFreeIndex=0;
   }
   public V get(K key){
      int hashValueOfKey = Math.abs(key.hashCode()% this.values.length);
      if(this.values[hashValueOfKey]== null){
         return null;
      }
      ArrayList<Pair<K,V>>valuesAtIndex = values[hashValueOfKey];
      
      for(int i=0;i<valuesAtIndex.size();i++){
         if(valuesAtIndex.get(i).getKey().equals(key)){
            return valuesAtIndex.get(i).getValue();
         }
      }
      return null;
   }
   
   /*public void add(K key,V value){
      int hashValueOfKey = Math.abs(key.hashCode()%this.values.length);
      if(this.values[hashValueOfKey] == null){
         values[hashValueOfKey] = new ArrayList<Pair<K,V>>();
      }

      ArrayList<Pair<K,V>> valuesAtIndex = values[hashValueOfKey];
      int index = -1;
      for(int i = 0;i < valuesAtIndex.size();i++){
         if(valuesAtIndex.get(i).getKey().equals(key)){
            index = i;
         } break;
      }
      if(index<0){
         valuesAtIndex.add(new Pair<K,V>(key, value));
         this.nextFreeIndex++;
      } else{
         valuesAtIndex.get(index).setValue(value);
      }
   }*/

   public ArrayList<Pair<K,V>> getListBasedOnKey(K key){
      int valuesAtIndex = Math.abs(key.hashCode()%values.length);
      if(this.values[valuesAtIndex]== null){
         return this.values[valuesAtIndex] = new ArrayList<Pair<K,V>>();
      }

      return this.values[valuesAtIndex];
   }

   public int getIndexOfKey(ArrayList<Pair<K,V>> lista, K key){
      int index =-1;
      for(int i =0;i<lista.size();i++){
         if(lista.get(i).getKey().equals(key)){
            return i;
         } break;
      } return -1;
   }

   public void add(K key,V value){
      int index = getIndexOfKey(getListBasedOnKey(key), key);
      ArrayList<Pair<K,V>> valuesAtIndex = getListBasedOnKey(key);
      if(index < 0){
         valuesAtIndex.add(new Pair<K,V>(key, value));
         this.nextFreeIndex++;
      } else {
         valuesAtIndex.get(index).setValue(value);
      }

      if(this.nextFreeIndex/this.values.length > 0.75){
         grow();
      }
   }

   private void grow(){
      //ArrayList new = valuesAtIndex;
      ArrayList<Pair<K,V>>[] newValues = new ArrayList[this.values.length*2];
      for(int i =0;i <this.values.length ;i++){
         copy(newValues, i);
      }
      this.values=newValues;
   }

   private void copy(ArrayList<Pair<K,V>>[] newArray,int idx){
      for (int i =0;i<this.values[idx].size();i++){
         Pair<K,V> values = this.values[idx].get(i);
         int hashvalue = Math.abs(values.getKey().hashCode()%newArray.length);

         if(newArray[hashvalue] == null){
            newArray[hashvalue] = new ArrayList<Pair<K,V>>();
         }
         newArray[hashvalue].add(values);
      }
   }
   public V remove(K key){
      int hashvalue = Math.abs(key.hashCode()%this.values.length);
      ArrayList<Pair<K,V>> valuesAtIndex = this.values[hashvalue];
      int index = -1;
      for(int i =0;i<valuesAtIndex.size();i++){
         if(valuesAtIndex.get(i).getKey().equals(key)){
            index = i;
      }
   }
      Pair<K,V> pair = valuesAtIndex.get(index);
      valuesAtIndex.remove(valuesAtIndex.get(index));
      return pair.getValue();
}
}
