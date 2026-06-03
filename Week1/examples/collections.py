l = [1,2,2,4] #List
s = {1,2,3,4} #Set
t = (1,2,3,4,5,5,5,6) #tuple
d = {"a":1, "b":2,"c":3}
#list.append(x) x is the value to be added to the end of the list
appended_list = ["I","declare","a","thumb"]
print(appended_list)
appended_list.append("war")
print(appended_list)

#list.extend(iterable) iterable is an iterable object, like another list
final_numbers = [5,6,7,8]
appended_list.extend(final_numbers)
print(appended_list)

#list.insert(i,x) index position that the object will be interted in front of
#So index 0 means front of the list, x is the value to be added
appended_list.insert(1,"one, two, three, four")
print(appended_list)

#list.remove(x) removes the first element to match x. Raises a ValueError if the item does not exist
appended_list.remove("thumb")
print(appended_list)

#list.pop([i]) i represents the OPTIONAL index position of the item you wish to return and remove from the list
#if no index is given then the last element in the list will both be returned and removed
appended_list.pop()
print(appended_list)

appended_list.clear()
print(appended_list)

#list.index(x[,start[,end]]) returns index of value x, where start and end are the optional start/end points
new_list=[1,2,3,4,5,3,6,"seven"]
print(new_list.index(4,1,5))
print("counter below")
print(new_list.count(3))

to_sort_numbers = [1,3,2,4,6,5,7,9,8,10]
print(to_sort_numbers)
to_sort_numbers.sort()
print(to_sort_numbers)
sort_using_key = [[1,"c"],[2,"a"],[3,"b"]]
def my_key(element):
    return element[1] # takes the second element in the nested list and uses it to sort the list
sort_using_key.sort(key=my_key)
# sort_using_key.sort(key= lambda x: x[1])
print(sort_using_key)

to_sort_numbers.reverse()
print(to_sort_numbers)
#or use below, thank you Landon
print(to_sort_numbers[::-1])


