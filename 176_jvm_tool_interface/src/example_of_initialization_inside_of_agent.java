public class example_of_initialization_inside_of_agent {
    // Example of initialization inside of Agent_OnLoad method/Contoh inisialisasi
    // dalam metode Agent_OnLoad

    // Callback for JVMTI_EVENT_VM_INIT

    /*
     * static void JNICALL vm_init(jvmtiEnv* jvmti, JNIEnv* env, jthread thread)
     * {
     * jint runtime_version;
     * jvmti->GetVersionNumber(&runtime_version);
     * stdout_message("JVMTI Version: %d\n", runtime_verision);
     * }
     * 
     * // Agent_OnLoad() is called first, we prepare for a VM_INIT event here.
     * 
     * JNIEXPORT jint JNICALL
     * Agent_OnLoad(JavaVM* vm, char* options, void* reserved)
     * {
     * jint rc;
     * jvmtiEventCallbacks callbacks;
     * jvmtiCapabilities capabilities;
     * jvmtiEnv* jvmti;
     * 
     * 
     * //Get JVMTI environment
     * 
     * rc = vm->GetEnv(reinterpret_cast<void **>(&jvmti), JVMTI_VERSION);
     * if (rc != JNI_OK)
     * {
     * return -1;
     * }
     * 
     * //Immediately after getting the jvmtiEnv* we need to ask for the capabilities
     * //this agent will need.
     * 
     * jvmti->GetCapabilities(&capabilities);
     * capabilities.can_tag_objects = 1;
     * jvmti->AddCapabilities(&capabilities);
     * 
     * //Set callbacks and enable event notifications
     * 
     * memset(&callbacks, 0, sizeof(callbacks));
     * callbacks.VMInit = &vm_init;
     * jvmti->SetEventCallbacks(&callbacks, sizeof(callbacks));
     * jvmti->SetEventNotificationMode(JVMTI_ENABLE, JVMTI_EVENT_VM_INIT, nullptr);
     * return JNI_OK;
     * }
     * 
     */
}
