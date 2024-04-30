public class iterate_over_objects_reachable_from_object {
    // Iterate over objects reachable from object (Heap 1.0)

    /*
     * #include <vector>
     * #include <string>
     * #include "agent_util.hpp"
     * //this file can be found in Java SE Development Kit 8u101 Demos and Samples
     * //see
     * http://download.oracle.com/otn-pub/java/jdk/8u101-b13-demos/jdk-8u101-windows
     * -x64-demos.zip
     * //jdk1.8.0_101.zip!\demo\jvmti\versionCheck\src\agent_util.h
     * 
     */

    /*
     * Struct used for jvmti->SetTag(object, <pointer to tag>);
     * http://docs.oracle.com/javase/7/docs/platform/jvmti/jvmti.html#SetTag
     */

    /*
     * typedef struct Tag
     * {
     * jlong referrer_tag;
     * jlong size;
     * char* classSignature;
     * jint hashCode;
     * } Tag;
     * 
     */

    // Utility function: jlong -> Tag*

    /*
     * static Tag* pointerToTag(jlong tag_ptr)
     * {
     * if (tag_ptr == 0)
     * {
     * return new Tag();
     * }
     * return (Tag*)(ptrdiff_t)(void*)tag_ptr;
     * }
     */

    // Utility function: Tag* -> jlong

    /*
     * static jlong tagToPointer(Tag* tag)
     * {
     * return (jlong)(ptrdiff_t)(void*)tag;
     * }
     */

    /*
     * Heap 1.0 Callback
     * http://docs.oracle.com/javase/7/docs/platform/jvmti/jvmti.html#
     * jvmtiObjectReferenceCallback
     */

    /*
     * static jvmtiIterationControl JNICALL heabObjectReferencesCallback(
     * jvmtiObjectReferenceKind reference_kind,
     * jlong class_tag,
     * jlong size,
     * jlong* tag_ptr,
     * jlong referrer_tag,
     * jint referrer_index,
     * void* user_data)
     * {
     * //iterate only over reference field
     * if (reference_kind != JVMTI_HEAP_REFERENCE_FIELD)
     * {
     * return JVMTI_ITERATION_IGNORE;
     * }
     * auto tag_ptr_list = (std::vector<jlong>*)(ptrdiff_t)(void*)user_data;
     * //create and assign tag
     * auto t = pointerToTag(*tag_ptr);
     * t->referrer_tag = referrer_tag;
     * t->size = size;
     * tag_ptr = tagToPointer(t);
     * //collect tag
     * (*tag_ptr_list).push_back(*tag_ptr);
     * return JVMTI_ITERATION_CONTINUE;
     * }
     */

    /*
     * Main function for demonstration of Iterate Over Objects Reachable From Object
     *
     * http://docs.oracle.com/javase/7/docs/platform/jvmti/jvmti.html#
     * IterateOverObjectsReachableFromObject
     */

    /*
     * void iterateOverObjectHeapReferences(jvmtiEnv* jvmti, JNIEnv* env, jobject
     * object)
     * {
     * std::vector<jlong> tag_ptr_list;
     * auto t = new Tag();
     * jvmti->SetTag(object, tagToPointer(t));
     * tag_ptr_list.push_back(tagToPointer(t));
     * stdout_message("tag list size before call callback: %d\n",
     * tag_ptr_list.size());
     * Call Callback for every reachable object reference
     * //see http://docs.oracle.com/javase/7/docs/platform/jvmti/jvmti.html#
     * //IterateOverObjectsReachableFromObject
     * 
     * jvmti->IterateOverObjectsReachableFromObject(object,
     * &heabObjectReferencesCallback,
     * (void*)&tag_ptr_list);
     * stdout_message("tag list size after call callback: %d\n",
     * tag_ptr_list.size());
     * if (tag_ptr_list.size() > 0)
     * {
     * jint found_count = 0;
     * jlong* tags = &tag_ptr_list[0];
     * jobject* found_objects;
     * jlong* found_tags;
     * 
     * //collect all tagged object (via *tag_ptr = pointer to tag )
     * //see http://docs.oracle.com/javase/7/docs/platform/jvmti/jvmti.html#
     * GetObjectsWithTags
     * 
     * jvmti->GetObjectsWithTags(tag_ptr_list.size(), tags, &found_count,
     * &found_objects,
     * &found_tags);
     * stdout_message("found %d objects\n", found_count);
     * for (auto i = 0; i < found_count; ++i)
     * {
     * jobject found_object = found_objects[i];
     * char* classSignature;
     * jclass found_object_class = env->GetObjectClass(found_object);
     * 
     * //Get string representation of found_object_class
     * //see http://docs.oracle.com/javase/7/docs/platform/jvmti/jvmti.html#
     * GetClassSignature
     * 
     * 
     * jvmti->GetClassSignature(found_object_class, &classSignature, nullptr);
     * jint hashCode;
     * 
     * //Getting hash code for found_object
     * //see http://docs.oracle.com/javase/7/docs/platform/jvmti/jvmti.html#
     * GetObjectHashCode
     * 
     * jvmti->GetObjectHashCode(found_object, &hashCode);
     * 
     * //save all it in Tag
     * Tag* t = pointerToTag(found_tags[i]);
     * t->classSignature = classSignature;
     * t->hashCode = hashCode;
     * }
     * //print all saved information
     * for (auto i = 0; i < found_count; ++i)
     * {
     * auto t = pointerToTag(found_tags[i]);
     * auto rt = pointerToTag(t->referrer_tag);
     * 
     * if (t->referrer_tag != 0)
     * {
     * stdout_message("referrer object %s#%d --> object %s#%d (size: %2d)\n",
     * rt->classSignature, rt->hashCode, t->classSignature, t->hashCode, t->size);
     * }
     * }
     * }
     * }
     * 
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
