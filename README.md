# Image Search Engine App 

Search Screen              |  Search Results
:-------------------------:|:-------------------------:
![Screenshot_20210202-023602_Dogs Search Engine](https://user-images.githubusercontent.com/37294453/106545391-3dbb7480-6501-11eb-8494-a65e248db797.jpg)|![APP Image](https://user-images.githubusercontent.com/37294453/100675043-1b20aa00-335e-11eb-9f72-45a46e5d7cd6.jpg  "APP Image")|
![Dogs Search Engine1](https://user-images.githubusercontent.com/37294453/106546949-27fb7e80-6504-11eb-8666-4a1bc87e11a2.jpg)|


___

### This is a simple image search engine application that searches images of all kinds with the help of REST API. Images together with usernames and likes are searched and displayed in a Recycleview.  This was accomplished with the aid of libraries like Glide, Retrofit, JetPacack suite libraries.....
___

We will search any image name and  display a list of them in the recyclerview, instead of loading all results at once into the recycler view we will use the paging three library from android jetpack to implement pagination. This will enable us to load the results in small pages which looks like a huge list and the user wouldn't really notice anything, it saves system resources and we don't have to download so much data at one.
___

**Glide** to load the images,
**Retrofit** with **Coroutines** to communicate with the **Rest API** , paging three will take care of launching these coroutines, we will just declare some suspend functions. 
___

Will will use a **Navigation component** to navigate from the gallay fragment with the recyclerview to the detail fragment.
___

**View Binding** to access our views in compile time safe way.
___

**Dagger Hilt** is a library that belongs to  jetpack built on top of dagger2 and makes dagger2 easier.Dagger2 is a dependency injection library.
___

 **MVVM** is the Architecture used in the project.
___
 **Intrumentation Test** with **JUnit** and **UI** Test with **Espresso**





